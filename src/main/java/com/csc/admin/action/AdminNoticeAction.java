package com.csc.admin.action;

import java.util.Date;
import java.util.List;

import com.csc.admin.data.dao.AdminDao;
import com.csc.admin.data.dao.MyBatisConfig;
import com.csc.admin.model.AdminNotice;

public class AdminNoticeAction extends BaseAction implements IActionMethods {

	private static final long serialVersionUID = 1L;

	private AdminNotice model;
	private List<AdminNotice> modelList;

	
	private AdminDao dao = new AdminDao(MyBatisConfig.getSqlSessionFactory());

	public AdminNotice getModel() {
		return model;
	}
	
	public void setModel(AdminNotice model) {
		this.model = model;
	}

	public List<AdminNotice> getModelList() {
		return modelList;
	}
	public void setModelList(List<AdminNotice> modelList) {
		this.modelList = modelList;
	}
	

	////////////==========================================================
	
	@Override
	public String list() {
		log.debug("AdminNotice list...");
		modelList = dao.lstAdminNotice();	
		
		convertSessionMessagesToActionMessages("admin-notice");
		
		return SUCCESS;
	}
	
	@Override
	public String view() {
    	log.debug("AdminNotice view...");
    	try {
        	validateId();

        	AdminNotice params = new AdminNotice();
        	params.setNoteId(new Long(id));
        	
        	model = dao.selAdminNotice(params);
        	
        	if (model == null) {
        		model = new AdminNotice();
        		addActionError("Failed to retrieve record from database for ID = " + id);
        	} 
        	
    	} catch (Exception e) {
    		model = new AdminNotice();
    		addActionError("Failed to retrieve record from database: " + e.getMessage());
    	
    	}
    	
		convertSessionMessagesToActionMessages("admin-notice");
    	
        return SUCCESS;
	}
	
	@Override
    public String edit()  {
    	//not used
		return null;
    }
	
	@Override
	public String add() {
		//not used
		return null;
	}
	
	@Override
	public String insert() {
    	log.debug("AdminNotice insert...");
    	
    	try {

        	model.setNoteUsr(getSessionUserId());
        	model.setNoteDt(new Date());
        	
        	dao.insAdminNotice(model);
        	
        	return SUCCESS;
            
    	} catch (Exception e) {
    		//ajax
    		log.error("Failed to insert Admin Notice", e);
    		return SUCCESS;    		
    	}
    	

	}
	
    @Override
	public String update() {
    	//not used
    	return null;
    }
	
	@Override
	public String delete() {
    	log.debug("AdminNotice delete...");
    	
    	try {
        	AdminNotice params = new AdminNotice();
        	params.setNoteId(new Long(id));
        	dao.delAdminNotice(params);  
        	
        	//to accommodate page redirect
        	super.addSessionMessage("admin-notice", "Record deleted.");
       	
        	
        	return SUCCESS;
        	
    	} catch (Exception e) {
    		addActionError("Failed to delete Admin Notice: " + e.getMessage());
    		return "input";
    	}

	}


}
