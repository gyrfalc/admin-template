package com.csc.admin.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csc.admin.data.AdminBldrDao;
import com.csc.admin.data.SqlBuilder;
import com.csc.admin.data.SqlRunner;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.model.ListItem;

public class AdminViewAction extends AdminAction {

	private static final long serialVersionUID = 1L;
	
	private String tblNm;
	private String keyVal;
	private AdminTbl tbl;
	private AdminRow row;
	
	private Map<String, List<ListItem>> listMap;
	private boolean getLists;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	private AdminBldrDao dao = new AdminBldrDao();

	public String viewRecord() {
		if (log.isDebugEnabled()) {
			log.debug("entering admin view view action...");
			log.debug("table name = " + tblNm);
			log.debug("key val = " + keyVal);
			log.debug("lang cd = " + super.getLangCd());			
		}

		// retrieve table info
		tbl = dao.getTable(tblNm);
		// retrieve the select columns
		List<AdminCol> selcols = dao.getColList(tblNm);
		// retrieve the key columns
		List<AdminCol> keycols = dao.getColKeyList(tblNm);
		
		// generate the SQL 
		String sql = sqlBuilder.buildSelSql(tbl, keyVal, selcols, keycols, super.getLangCd());
		
		// execute the SQL to retrieve the row as a list of column data
		row = sqlRunner.executeSelSql(selcols, sql);
		
		// if nothing is returned by the query, send back the empty columns
		if (row == null) {
			row = new AdminRow("", selcols);
		}
		
		if (getLists) {
			listMap = new HashMap<String, List<ListItem>>();
			for (AdminCol sc : selcols) {
				if (sc.isList()) {
					listMap.put(sc.getColNm(), dao.getList(sc.getListNm()));
					if (log.isDebugEnabled()) { 
						log.debug("retrieve list for col nm = " + sc.getColNm() + " list nm = " + sc.getListNm());
						log.debug("list count = " + (listMap.get(sc.getColNm()) == null? "null" : listMap.get(sc.getColNm()).size()));
					}
				}
			}		
			getLists = false;
		} else {
			if (log.isDebugEnabled()) { log.debug("no lists retrieved for this record"); }
		}
		
		if (log.isDebugEnabled()) { log.debug("leaving view action..."); }
		return SUCCESS;
	}
	
	public String editRecord() {
		log.debug("entering admin edit action ...");
		getLists = true;
		return viewRecord();
	}
	
	public String updRecord() {
		log.debug("entering admin update action...");
		
		@SuppressWarnings("unchecked")
		Map <String, String[]> paramMap = request.getParameterMap();
		
		if (log.isDebugEnabled()) {
			if (paramMap != null && paramMap.size() > 0) {
				Enumeration<?> pnms = request.getParameterNames();
				while (pnms.hasMoreElements()) {
					Object nm = pnms.nextElement();
					log.debug("parameter " + nm + " = " + paramMap.get(nm)[0]);
				}
				
				
			} else {
				log.debug("parameter map is null or empty!");
			}
		}
		
		
		
		getLists = false;
		return viewRecord();
	}
	
	public String addRecord() {
		
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

	public String getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
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
}
