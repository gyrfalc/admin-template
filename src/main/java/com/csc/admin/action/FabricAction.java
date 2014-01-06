package com.csc.admin.action;

import java.util.Date;
import java.util.List;

import com.csc.admin.data.dao.AdminDao;
import com.csc.admin.data.dao.FabricDao;
import com.csc.admin.data.dao.MyBatisConfig;
import com.csc.admin.model.Fabric;
import com.csc.admin.model.ListItem;


public class FabricAction extends BaseAction implements IActionMethods {

	private static final long serialVersionUID = 1L;
	private Fabric model;
	private List<Fabric> modelList;
	
	private List<ListItem> lstFabricFamilyCd;

	
	private FabricDao dao = new FabricDao(MyBatisConfig.getSqlSessionFactory());
	private AdminDao adao = new AdminDao(MyBatisConfig.getSqlSessionFactory());

	public Fabric getModel() {
		return model;
	}
	
	public void setModel(Fabric model) {
		this.model = model;
	}

	public List<Fabric> getModelList() {
		return modelList;
	}
	public void setModelList(List<Fabric> modelList) {
		this.modelList = modelList;
	}
	
	public List<ListItem> getLstFabricFamilyCd() {
		return lstFabricFamilyCd;
	}

	public void setLstFabricFamilyCd(List<ListItem> lstFabricFamilyCd) {
		this.lstFabricFamilyCd = lstFabricFamilyCd;
	}
	

	////////////==========================================================
	
	private void loadLists() {
		try {
		   	lstFabricFamilyCd = adao.selList("lst_fabric_family");
			
		} catch (Exception e) {
			log.error("failed to load lists", e);
		}
	}
	
	@Override
	public String list() {
		log.debug("Fabric list...");
		modelList = dao.lstFabric(super.getLangCd());	
		
		convertSessionMessagesToActionMessages("fabric");
		
		return SUCCESS;
	}
	
	@Override
	public String view() {
    	log.debug("Fabric view...");
    	try {
        	validateId();

        	Fabric params = new Fabric();
        	params.setFabricCd(id);	
        	params.setLangCd(super.getLangCd());
        	
        	model = dao.selFabric(params);
        	
        	if (model == null) {
        		model = new Fabric();
        		addActionError("Failed to retrieve record from database for ID = " + id);
        	} 
        	
    	} catch (Exception e) {
    		model = new Fabric();
    		addActionError("Failed to retrieve record from database: " + e.getMessage());
    	
    	}
    	
		convertSessionMessagesToActionMessages("fabric");
    	
        return SUCCESS;
	}
	
	@Override
    public String edit()  {
    	log.debug("Fabric edit...");
    	loadLists();
    	return view();
    }
	
	@Override
	public String add() {
    	log.debug("Fabric add...");
    	model = new Fabric();
    	loadLists();
     	return SUCCESS;
	}
	
	@Override
	public String insert() {
    	log.debug("Fabric insert...");
    	
    	try {
    		model.setLangCd(super.getLangCd());
    		
    		List<String> msgs = model.validate();
        	if (msgs.size() > 0) {
        		for (String s: msgs) {
        			addActionError(s);
        		}
        		return "input";
        	}
        	
        	Fabric obj = dao.selFabric(model);
        	if (obj != null) {
        		addActionError("Record already exists in database.");
        		return "input";
        	}
        	
        	model.setModBy(getSessionUserId());
        	model.setModDt(new Date());
        	
        	if (model.isLangEnabled() && model.doCloneLang()) {
        		List<ListItem> langs = super.getLangList();
        		boolean hasErrs = false;
        		for (ListItem i : langs) {
        			model.setLangCd(i.getId());
        			try {
        				if (i.getId().equals(super.getLangCd())) {
        					model.setPubStat("MOD");
        				} else {
        					model.setPubStat("TRANS");
        				}
        				dao.insFabric(model);
        			} catch (Exception e) {
        				addActionError("Failed to create record for language " + i.getName());
        				hasErrs = true;
        			}
        			
        		}
        		if (!hasErrs) {
                	super.addSessionMessage("fabric", "Records created successfully.");
        		}
        	} else {    
        		model.setPubStat("MOD");
        		model.setLangCd(super.getLangCd());
            	dao.insFabric(model);
            	super.addSessionMessage("fabric", "Record created successfully.");
        	}
        	
        	model = dao.selFabric(model);
        	
        	//to accommodate page redirect
        	session.put("modelId", model.getId());
        	
        	return SUCCESS;
            
    	} catch (Exception e) {
    		loadLists();
    		addActionError("Failed to create fabric record: " + e.getMessage());
    		return "input";      		
    	}
    	

	}
	
    @Override
	public String update() {
    	log.debug("Fabric update...");

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
        	model.setLangCd(super.getLangCd());
    		model.setPubStat("MOD");

        	dao.updFabric(model);
        	
        	//to accommodate page redirect
        	session.put("modelId", model.getId());
        	super.addSessionMessage("fabric", "Record updated.");
        	
         	return SUCCESS;
            
    	} catch (Exception e) {
    		loadLists();
    		addActionError("Failed to update fabric record: " + e.getMessage());
    		return "input";   		
    	}
    	

    }
	
	@Override
	public String delete() {
    	log.debug("Fabric delete...");
    	
    	try {
        	Fabric params = new Fabric();
        	params.setFabricCd(id);
        	params.setLangCd(super.getLangCd());
        	dao.delFabric(params);  
        	
        	//to accommodate page redirect
        	super.addSessionMessage("fabric", "Record deleted.");
       	
        	
        	return SUCCESS;
        	
    	} catch (Exception e) {
    		addActionError("Failed to delete fabric: " + e.getMessage());
    		return "input";
    	}

	}



}
