package com.csc.admin.data;

import java.util.List;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminNotice;
import com.csc.admin.model.AdminParam;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.model.ListItem;

public interface IAdminBldrDao {
	
	public List<AdminTbl> getTableList();
	public AdminTbl getTable(String tblNm);
	
	public List<AdminCol> getColList(String tblNm);
	public List<AdminCol> getColSortList(String tblNm);
	public List<AdminCol> getColSrchList(String tblNm);
	public List<AdminCol> getColKeyList(String tblNm);
	public List<AdminCol> getColMetaList(String tblNm);
	public List<AdminCol> getColUpdList(String tblNm);
	public AdminCol getCol(String tblNm, String colNm);
	
	public AdminParam getAdminParam(String paramNm);
	
	public List<AdminNotice> getNoticeList();
	
	public List<ListItem> getList(String listViewNm);
}
