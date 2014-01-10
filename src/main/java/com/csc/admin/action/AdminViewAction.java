package com.csc.admin.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csc.admin.data.SqlBuilder;
import com.csc.admin.data.SqlRunner;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.model.ListItem;
import com.csc.admin.util.AdminConstants;

public class AdminViewAction extends AdminAction {

	private static final long serialVersionUID = 1L;
	
	private String tblNm;
	private String key;
	private AdminTbl tbl;
	private AdminRow row;
	
	private Map<String, List<ListItem>> listMap;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	
	private String cloneLang;

	public String viewRecord() {
		log.debug("entering admin view action ...");
		return retrieveRecord(false);
	}
	
	public String editRecord() {
		log.debug("entering admin edit action ...");
		return retrieveRecord(true);
	}
	
	public String retrieveRecord(boolean getLists) {
		if (log.isDebugEnabled()) {
			log.debug("entering admin retrieve action...");
			log.debug("table name = " + tblNm);
			log.debug("key val = " + key);
			log.debug("lang cd = " + super.getLangCd());			
		}

		// retrieve table info
		tbl = metadao.getTable(tblNm);
		// retrieve the table columns
		List<AdminCol> selcols = metadao.getColList(tblNm);
		// retrieve the key columns
		List<AdminCol> keycols = metadao.getColKeyList(tblNm);
		
		// generate the SQL 
		String sql = sqlBuilder.buildSelSql(tbl, key, selcols, keycols, super.getLangCd());
		
		// execute the SQL to retrieve the row as a list of column data
		row = sqlRunner.executeSelSql(selcols, sql);
		
		// if nothing is returned by the query, send back the empty columns
		if (row == null) {
			row = new AdminRow("", selcols);
		}
		
		if (getLists) {
			retrieveSelectLists(selcols);
		} else {
			if (log.isDebugEnabled()) { log.debug("no lists retrieved for this record"); }
		}
		
		if (log.isDebugEnabled()) { log.debug("leaving retrieve action..."); }
		return SUCCESS;		
	}
	
	private void retrieveSelectLists(List<AdminCol> selcols) {
		listMap = new HashMap<String, List<ListItem>>();
		for (AdminCol sc : selcols) {
			if (sc.isList()) {
				listMap.put(sc.getColNm(), metadao.getList(sc.getListNm()));
				if (log.isDebugEnabled()) { 
					log.debug("retrieve list for col nm = " + sc.getColNm() + " list nm = " + sc.getListNm());
					log.debug("list count = " + (listMap.get(sc.getColNm()) == null? "null" : listMap.get(sc.getColNm()).size()));
				}
			}
		}			
	}
	
	public String addRecord() {
		log.debug("entering admin add action...");
		// retrieve the table
		tbl = metadao.getTable(tblNm);
		// retrieve the table columns
		List<AdminCol> selcols = metadao.getColList(tblNm);		
		// create an empty row object
		row = new AdminRow("", selcols);
		// retrieve select lists
		retrieveSelectLists(selcols);
		log.debug("leaving admin add action...");
		return SUCCESS;
	}
	
	public String updRecord() {
		log.debug("entering admin update action...");
		
		@SuppressWarnings("unchecked")
		Map <String, String[]> data = request.getParameterMap();
		
		if (log.isDebugEnabled()) {
			if (data != null && data.size() > 0) {
				Enumeration<?> pnms = request.getParameterNames();
				while (pnms.hasMoreElements()) {
					Object nm = pnms.nextElement();
					log.debug("parameter " + nm + " = " + data.get(nm)[0]);
				}
				
				
			} else {
				log.debug("parameter map is null or empty!");
			}
		}
		
		tbl = metadao.getTable(tblNm);
		List<AdminCol> updcols = metadao.getColUpdList(tblNm); 
		List<AdminCol> metacols = metadao.getColMetaList(tblNm);
		List<AdminCol> keycols = metadao.getColKeyList(tblNm); 
		List<AdminCol> selcols = metadao.getColList(tblNm);
		
		
		String sql = sqlBuilder.buildUpdSql(tbl, key, updcols, metacols, keycols, data, getSessionUserId(), getLangCd());
		int result = sqlRunner.executeUpdSql(sql);
		log.debug("# records updated: " + result);
		// turn around and retrieve the record to get latest meta data
		sql = sqlBuilder.buildSelSql(tbl, key, selcols, keycols, getLangCd());
		row = sqlRunner.executeSelSql(selcols, sql);

		log.debug("leaving update action...");

		return SUCCESS;
	}
	
	public String insRecord() {
		log.debug("entering admin insert action...");
		
		@SuppressWarnings("unchecked")
		Map <String, String[]> data = request.getParameterMap();
		
		if (log.isDebugEnabled()) {
			if (data != null && data.size() > 0) {
				Enumeration<?> pnms = request.getParameterNames();
				while (pnms.hasMoreElements()) {
					Object nm = pnms.nextElement();
					log.debug("parameter " + nm + " = " + data.get(nm)[0]);
				}
				
				
			} else {
				log.debug("parameter map is null or empty!");
			}
		}
		
		tbl = metadao.getTable(tblNm);
		List<AdminCol> keycols = metadao.getColKeyList(tblNm); 
		List<AdminCol> inscols = metadao.getColList(tblNm);
		
		int result = 0;
		if ("Y".equalsIgnoreCase(cloneLang)) {
			List<ListItem> langList = metadao.getList("lst_language");
			for (ListItem l : langList) {
				String sql = sqlBuilder.buildInsSql(tbl, inscols, data, getSessionUserId(), l.getId());
				result += sqlRunner.executeUpdSql(sql);					
			}
		} else {
			String sql = sqlBuilder.buildInsSql(tbl, inscols, data, getSessionUserId(), getLangCd());
			result = sqlRunner.executeUpdSql(sql);			
		}
		log.debug("# records updated: " + result);
		
		// generate the key value
		StringBuilder keyval = new StringBuilder();
		boolean first = true;
		for (AdminCol k : keycols) {
			if (!first) { keyval.append(AdminConstants.KEY_DELIMITER); }
			keyval.append(data.get(k.getColNm())[0]);
			first = false;
		}
		key = keyval.toString();
		
		// turn around and retrieve the record to get latest meta data
		String sql = sqlBuilder.buildSelSql(tbl, key, inscols, keycols, getLangCd());
		row = sqlRunner.executeSelSql(inscols, sql);
		
		
		log.debug("leaving insert action...");

		return SUCCESS;
	}


	public AdminTbl getTbl() {
		return tbl;
	}

	public void setTbl(AdminTbl tbl) {
		this.tbl = tbl;
	}


	public String getTblNm() {
		return tblNm;
	}

	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public AdminRow getRow() {
		return row;
	}

	public void setRow(AdminRow row) {
		this.row = row;
	}

	public Map<String, List<ListItem>> getListMap() {
		return listMap;
	}

	public void setListMap(Map<String, List<ListItem>> listMap) {
		this.listMap = listMap;
	}

	public String getCloneLang() {
		return cloneLang;
	}

	public void setCloneLang(String cloneLang) {
		this.cloneLang = cloneLang;
	}
}
