package com.csc.admin.action;

import java.util.Date;
import java.util.List;

import com.csc.admin.data.dao.FabricFamilyDao;
import com.csc.admin.data.dao.MyBatisConfig;
import com.csc.admin.model.FabricFamily;

public class FabricFamilyAction extends BaseAction implements IActionMethods {

	private static final long serialVersionUID = 1L;
	private FabricFamily model;
	private List<FabricFamily> modelList;

	
	private FabricFamilyDao dao = new FabricFamilyDao(MyBatisConfig.getSqlSessionFactory());

	public FabricFamily getModel() {
		return model;
	}
	
	public void setModel(FabricFamily model) {
		this.model = model;
	}

	public List<FabricFamily> getModelList() {
		return modelList;
	}
	public void setModelList(List<FabricFamily> modelList) {
		this.modelList = modelList;
	}
	

	////////////==========================================================
	
	@Override
	public String list() {
		log.debug("FabricFamily list...");
		modelList = dao.lstFabricFamily();	
		
		convertSessionMessagesToActionMessages("FabricFamily");
		
		return SUCCESS;
	}
	
	@Override
	public String view() {
    	log.debug("FabricFamily view...");
    	try {
        	validateId();

        	FabricFamily params = new FabricFamily();
        	params.setFabricFamilyCd(id);
        	
        	model = dao.selFabricFamily(params);
        	
        	if (model == null) {
        		model = new FabricFamily();
        		addActionError("Failed to retrieve record from database for ID = " + id);
        	} 
        	
    	} catch (Exception e) {
    		model = new FabricFamily();
    		addActionError("Failed to retrieve record from database: " + e.getMessage());
    	
    	}
    	
		convertSessionMessagesToActionMessages("FabricFamily");
    	
        return SUCCESS;
	}
	
	@Override
    public String edit()  {
    	log.debug("FabricFamily edit...");
    	return view();
    }
	
	@Override
	public String add() {
    	log.debug("FabricFamily add...");
    	model = new FabricFamily();
    	return SUCCESS;
	}
	
	@Override
	public String insert() {
    	log.debug("FabricFamily insert...");
    	
    	try {
        	List<String> msgs = model.validate();
        	if (msgs.size() > 0) {
        		for (String s: msgs) {
        			addActionError(s);
        		}
        		return "input";
        	}
        	
        	FabricFamily obj = dao.selFabricFamily(model);
        	if (obj != null) {
        		addActionError("Record already exists in database.");
        		return "input";
        	}
        	
        	model.setModBy(getSessionUserId());
        	model.setModDt(new Date());
        	
        	dao.insFabricFamily(model);
        	model = dao.selFabricFamily(model);
        	
        	//to accommodate page redirect
        	session.put("modelId", model.getId());
        	super.addSessionMessage("FabricFamily", "Record created.");
        	
        	return SUCCESS;
            
    	} catch (Exception e) {
    		addActionError("Failed to create FabricFamily record: " + e.getMessage());
    		return "input";      		
    	}
    	

	}
	
    @Override
	public String update() {
    	log.debug("FabricFamily update...");

    	try {
        	List<String> msgs = model.validate();
        	if (msgs.size() > 0) {
        		for (String s: msgs) {
        			addActionError(s);
        		}
        		return "input";
        	}

        	model.setModBy(getSessionUserId());
        	model.setModDt(new Date());

        	dao.updFabricFamily(model);
        	
        	//to accommodate page redirect
        	session.put("modelId", model.getId());
        	super.addSessionMessage("FabricFamily", "Record updated.");
        	
         	return SUCCESS;
            
    	} catch (Exception e) {
    		addActionError("Failed to update FabricFamily record: " + e.getMessage());
    		return "input";   		
    	}
    	

    }
	
	@Override
	public String delete() {
    	log.debug("FabricFamily delete...");
    	
    	try {
        	FabricFamily params = new FabricFamily();
        	params.setFabricFamilyCd(id);
        	dao.delFabricFamily(params);  
        	
        	//to accommodate page redirect
        	super.addSessionMessage("FabricFamily", "Record deleted.");
       	
        	
        	return SUCCESS;
        	
    	} catch (Exception e) {
    		addActionError("Failed to delete FabricFamily: " + e.getMessage());
    		return "input";
    	}

	}


}
