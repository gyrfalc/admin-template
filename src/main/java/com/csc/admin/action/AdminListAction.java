package com.csc.admin.action;

import java.util.List;
import java.util.Map;

import com.csc.admin.data.SqlBuilder;
import com.csc.admin.data.SqlRunner;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.model.AdminTbl;

public class AdminListAction extends AdminAction {

	private static final long serialVersionUID = 1L;
	private String tblUrlNm;
	private List<AdminRow> rowlist;
	private List<AdminCol> collist;
	private AdminTbl tbl;
	private String qryStr;
	private String pageTitle;
	private String pageInfo;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	
	public String view() throws Exception {
		log.debug("entering list view action... ");
		// retrieve table
		tbl = metadao.getTableForUrl(tblUrlNm);
		// get list of columns to display on search table
		collist = metadao.getColDsplTblList(tbl.getTblNm());
		// get list of sort columns
		List<AdminCol> sortcols = metadao.getColSortList(tbl.getTblNm());
		// get sql to retrieve those columns
		String sql = sqlBuilder.buildListSql(tbl, collist, sortcols, super.getLangCd());
		// execute sql to retrieve row data
		rowlist = sqlRunner.executeListSql(collist, sql);
		
		pageTitle = "Index";
		pageInfo = tbl.getShortDesc();
		
		log.debug("leaving execute action...");
		return SUCCESS;
	}

	
	public String search() throws Exception {
		log.debug("entering list search result action... ");
		// retrieve table
		tbl = metadao.getTableForUrl(tblUrlNm);
		// get list of columns to display on search table
		collist = metadao.getColDsplTblList(tbl.getTblNm());
		// get list of sort columns
		List<AdminCol> sortcols = metadao.getColSortList(tbl.getTblNm());
		// get list of columns to search
		List<AdminCol> srchcols = metadao.getColSrchList(tbl.getTblNm());

		// get sql to retrieve those columns
		@SuppressWarnings("unchecked")
		Map <String, String[]> data = request.getParameterMap();
		String sql = sqlBuilder.buildSearchSql(tbl, collist, sortcols, srchcols, data, super.getLangCd());		
		// execute sql to retrieve row data
		rowlist = sqlRunner.executeListSql(collist, sql);
		
		try {
			qryStr = sql.split("where")[1].split("order by")[0];
			pageInfo = "You searched for: " + qryStr;
		} catch (Exception e) {
			pageInfo = "";
		}
		
		pageTitle="Search Results";
		
		
		log.debug("leaving execute action...");
		return SUCCESS;		
	}

	public String getTblUrlNm() {
		return tblUrlNm;
	}

	public void setTblUrlNm(String tblUrlNm) {
		this.tblUrlNm = tblUrlNm;
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

	public String getQryStr() {
		return qryStr;
	}

	public void setQryStr(String qryStr) {
		this.qryStr = qryStr;
	}


	public String getPageTitle() {
		return pageTitle;
	}


	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}


	public String getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}


}
