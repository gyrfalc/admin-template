package com.csc.admin.action;

import java.util.List;

import com.csc.admin.data.SqlBuilder;
import com.csc.admin.data.SqlRunner;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.model.AdminTbl;

public class AdminListAction extends AdminAction {

	private static final long serialVersionUID = 1L;
	private String tblNm;
	private List<AdminRow> rowlist;
	private List<AdminCol> collist;
	private AdminTbl tbl;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	
	public String execute() throws Exception {
		log.debug("entering execute action... ");
		// retrieve table
		tbl = metadao.getTable(tblNm);
		// get list of columns to display on search table
		collist = metadao.getColSrchList(tblNm);
		// get list or sort columns
		List<AdminCol> sortcols = metadao.getColSortList(tblNm);
		// get sql to retrieve those columns
		String sql = sqlBuilder.buildRowListSql(tbl, collist, sortcols, super.getLangCd());
		// execute sql to retrieve row data
		rowlist = sqlRunner.executeListSql(collist, sql);
		
		log.debug("leaving execute action...");
		return SUCCESS;
	}

	public String getTblNm() {
		return tblNm;
	}

	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}

	public List<AdminRow> getRowlist() {
		return rowlist;
	}

	public void setRowlist(List<AdminRow> rowlist) {
		this.rowlist = rowlist;
	}

	public AdminTbl getTbl() {
		return tbl;
	}

	public void setTbl(AdminTbl tbl) {
		this.tbl = tbl;
	}

	public List<AdminCol> getCollist() {
		return collist;
	}

	public void setCollist(List<AdminCol> colnmlist) {
		this.collist = colnmlist;
	}


}
