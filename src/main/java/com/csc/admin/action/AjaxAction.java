package com.csc.admin.action;

import com.csc.admin.data.dao.AdminDao;
import com.csc.admin.data.dao.MyBatisConfig;

public class AjaxAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String ajaxMessage;
	private String userLangCd;
	
	public String setLangChoice() {
		log.debug("set Lang Choice: language = " + userLangCd);
		AdminDao dao = new AdminDao(MyBatisConfig.getSqlSessionFactory());
		String userLangNm = dao.selLangNm(userLangCd);
		super.setLangCd(userLangCd);
		super.setLangNm(userLangNm);
		
		ajaxMessage = "{\"status\":\"OK\"}";
		
		return SUCCESS;
		
	}
	
	
	public String getAjaxMessage() {
		return ajaxMessage;
	}
	public void setAjaxMessage(String ajaxMessage) {
		this.ajaxMessage = ajaxMessage;
	}


	public String getUserLangCd() {
		return userLangCd;
	}


	public void setUserLangCd(String userLangCd) {
		this.userLangCd = userLangCd;
	}

}
