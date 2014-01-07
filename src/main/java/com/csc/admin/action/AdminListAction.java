package com.csc.admin.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.csc.admin.data.SqlBuilder;
import com.csc.admin.data.SqlRunner;
import com.csc.admin.data.dao.AdminBldrDao;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.model.AdminTbl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminListAction extends ActionSupport  implements SessionAware, ParameterAware, ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 1L;
	private String tblNm;
	private List<AdminRow> rowlist;
	private List<AdminCol> colnmlist;
	private AdminTbl tbl;
	
	private SqlBuilder sqlBuilder = new SqlBuilder();
	private SqlRunner sqlRunner = new SqlRunner();
	private AdminBldrDao dao = new AdminBldrDao();
	
	private static final Logger log = Logger.getLogger(AdminListAction.class);

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String execute() throws Exception {
		log.debug("entering execute action... ");
		// retrieve table
		tbl = dao.getTable(tblNm);
		// get list of columns to display on search table
		colnmlist = dao.getColSrchList(tblNm);
		// get sql to retrieve those columns
		String sql = sqlBuilder.buildTblSrchSql(tblNm);
		// execute sql to retrieve row data
		rowlist = sqlRunner.executeListSql(colnmlist, sql);
		
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

	public List<AdminCol> getColnmlist() {
		return colnmlist;
	}

	public void setColnmlist(List<AdminCol> colnmlist) {
		this.colnmlist = colnmlist;
	}


}
