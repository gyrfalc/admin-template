package com.csc.admin.data.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csc.admin.model.AdminNotice;
import com.csc.admin.model.ListItem;

public interface IAdminMap {
	
	public List<AdminNotice> lstAdminNotice();
	public AdminNotice selAdminNotice(AdminNotice params);
	public void insAdminNotice(AdminNotice params);
	public void delAdminNotice(AdminNotice params);
	
	public List<ListItem> selList(@Param("viewNm") String viewNm);

	public String selLangNm(@Param("langCd") String langCd);
}
