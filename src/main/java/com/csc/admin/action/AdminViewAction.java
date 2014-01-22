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
	
	private String tblUrlNm;
	private String key;
	private AdminTbl tbl;
	private AdminRow row;
	
	private Map<String, List<ListItem>> listMap;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	
	private String cloneLang;

	public String viewRecord() {
		log.debug("entering admin view action ...");
		return retrieveRecord(true);
	}
	
	public String editRecord() {
		log.debug("entering admin edit action ...");
		return retrieveRecord(true);
	}
	
	public String retrieveRecord(boolean getLists) {
		if (log.isDebugEnabled()) {
			log.debug("entering admin retrieve action...");
			log.debug("table url name = " + tblUrlNm);
			log.debug("key val = " + key);
			log.debug("lang cd = " + super.getLangCd());			
		}

		// retrieve table info
		tbl = metadao.getTableForUrl(tblUrlNm);
		// retrieve the table columns
		List<AdminCol> selcols = metadao.getColList(tbl.getTblNm());
		
		// retrieve the key columns
		List<AdminCol> keycols = metadao.getColKeyList(tbl.getTblNm());
		
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
				listMap.put(sc.getColNm(), metadao.getList(sc.getListNm(), super.getLangCd()));
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
		tbl = metadao.getTableForUrl(tblUrlNm);
		// retrieve the table columns
		List<AdminCol> cols = metadao.getColList(tbl.getTblNm());		
		// set default values
		for (AdminCol col : cols) {
			String dflt = col.getDflt();
			if (dflt != null) {
				if (AdminConstants.DFLT_TYPE_INCREMENT.equals(dflt)) {
					
					col.setVal(sqlRunner.executeIncrementSql(sqlBuilder.buildIncrementSql(tbl, col)));
					
				} else if (AdminConstants.DFLT_TYPE_SEQUENCE.equals(dflt)) {
		
					col.setVal(sqlRunner.executeIncrementSql(sqlBuilder.buildSequenceSql(col.getDfltVal())));
					
				} else {
					col.setVal(col.getDfltVal());
				}
			}
		}
		
		// create an empty row object
		row = new AdminRow("", cols);
		// retrieve select lists
		retrieveSelectLists(cols);
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
		
		tbl = metadao.getTableForUrl(tblUrlNm);
		List<AdminCol> updcols = metadao.getColUpdList(tbl.getTblNm()); 
		List<AdminCol> metacols = metadao.getColMetaList(tbl.getTblNm());
		List<AdminCol> keycols = metadao.getColKeyList(tbl.getTblNm()); 
		List<AdminCol> selcols = metadao.getColList(tbl.getTblNm());
		
		if (super.validateRecord(updcols, data)) {
			String sql = sqlBuilder.buildUpdSql(tbl, key, updcols, metacols, keycols, data, getSessionUserId(), getLangCd());
			int result = sqlRunner.executeUpdSql(sql);
			log.debug("# records updated: " + result);
			// turn around and retrieve the record to get latest meta data
			sql = sqlBuilder.buildSelSql(tbl, key, selcols, keycols, getLangCd());
			row = sqlRunner.executeSelSql(selcols, sql);
			
			// retrieve lists
			retrieveSelectLists(selcols);

			log.debug("leaving update action...");

			return SUCCESS;			
		} else {
			retrieveRecord(true);
			log.debug("validation errors occurred, returning to input...");

			return INPUT;			
			
		}
		
		

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
		
		tbl = metadao.getTableForUrl(tblUrlNm);
		List<AdminCol> keycols = metadao.getColKeyList(tbl.getTblNm()); 
		List<AdminCol> inscols = metadao.getColList(tbl.getTblNm());
		
		if (super.validateRecord(inscols, data)) {
			int result = 0;
			if ("Y".equalsIgnoreCase(cloneLang)) {
				List<ListItem> langList = metadao.getList("language", getLangCd());
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
	
			// retrieve lists
			retrieveSelectLists(inscols);

			
			log.debug("leaving insert action...");

			return SUCCESS;			
		} else {
			log.debug("validation errors occurred, returning to input...");
			addRecord();
			return INPUT;
		}
		

	}
	
	public String delRecord() {
		log.debug("entering admin delete action...");
		
		String returnval = SUCCESS;
		try {
			tbl = metadao.getTableForUrl(tblUrlNm);
			List<AdminCol> keycols = metadao.getColKeyList(tbl.getTblNm()); 
			
			String sql = sqlBuilder.buildDelSql(tbl, keycols, key);
			sqlRunner.executeUpdSql(sql);			
		} catch (Exception e) {
			addActionError("Failed to delete record: " + e.getMessage());
			retrieveRecord(false);
			returnval = INPUT;
			
		}
		return returnval;		
	}
	
	
	public String search() throws Exception {
		log.debug("entering admin search action... ");
		// retrieve table
		tbl = metadao.getTableForUrl(tblUrlNm);
		// get list of columns to search
		List<AdminCol> srchcols = metadao.getColSrchList(tbl.getTblNm());
		// create an empty row object
		row = new AdminRow("", srchcols);
		retrieveSelectLists(srchcols);
		log.debug("leaving admin action...");
		return SUCCESS;		

	}


	public AdminTbl getTbl() {
		return tbl;
	}

	public void setTbl(AdminTbl tbl) {
		this.tbl = tbl;
	}


	public String getTblUrlNm() {
		return tblUrlNm;
	}

	public void setTblUrlNm(String tblUrlNm) {
		this.tblUrlNm = tblUrlNm;
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
