package com.csc.admin.action;

import java.util.List;

import com.csc.admin.model.AdminNotice;

public class AdminNoticeAction extends AdminAction {

	private static final long serialVersionUID = 1L;

	private AdminNotice notice;
	private List<AdminNotice> noticeList;

	

	////////////==========================================================
	
	@Override
	public String execute() {
		log.debug("Admin Notice execute...");
		
		noticeList = metadao.getNoticeList();
		
		convertSessionMessagesToActionMessages("admin-notice");
		
		log.debug("leaving Admin Notice execute...");
		return SUCCESS;
	}



	public AdminNotice getNotice() {
		return notice;
	}

	public void setNotice(AdminNotice notice) {
		this.notice = notice;
	}

	public List<AdminNotice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<AdminNotice> noticeList) {
		this.noticeList = noticeList;
	}


}
