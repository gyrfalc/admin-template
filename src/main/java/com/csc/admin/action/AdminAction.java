package com.csc.admin.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.admin.data.AdminBldrDao;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.model.ListItem;
import com.csc.admin.util.AdminConstants;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction  extends ActionSupport  implements SessionAware, ParameterAware, ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	protected Map<String,Object> session;
	
	protected Map<String, String[]> parameters;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;  
	
	protected String userNm;
	protected String id;
	protected AdminBldrDao metadao = new AdminBldrDao();
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getSessionUserId() {
		String userId = (String) session.get("userId");
		if (userId == null) {
			userId = "0";
		}
		return userId;
		
	}
	
	public String getUserNm() {
		return "Joe User";
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	protected  void validateId() throws Exception {
    	log.debug("validate id = " + id);
    	if (StringUtils.isEmpty(id)) {
    		id = (String) session.get("modelId");
    		log.debug("id retrieved from session = " + id);
    		if (StringUtils.isEmpty(id)) {
    			throw new Exception("Record ID must be provided.");
    		}
    	}		
	}
	
	@SuppressWarnings("unchecked")
	protected List<String> getSessionMessages(String tableNm) {
		List<String> msgs = (List<String>) session.get(tableNm);
		session.remove(tableNm);  //clear messages on retrieve
		return msgs;
	}
	
	protected void setSessionMessages(String tableNm, List<String> msgs) {
		session.put(tableNm, msgs);
	}
	
	@SuppressWarnings("unchecked")
	protected void addSessionMessage(String tableNm, String msg) {
		ArrayList<String> msgs = (ArrayList<String>) session.get(tableNm);
		if (msgs == null) {
			msgs = new ArrayList<String>();
		}
		msgs.add(msg);
		session.put(tableNm, msgs);
	}
	
	protected void convertSessionMessagesToActionMessages(String tableNm) {
		List<String> msgs = getSessionMessages(tableNm);
		if (msgs != null) {
			for (String msg: msgs) {
				addActionMessage(msg);
			}
		}
	}
	public String getLangCd() {
		String langCd = (String) session.get("lang-cd");
		if (StringUtils.isEmpty(langCd)) {
			langCd = "en";
		}
		return langCd;
	}
	public void setLangCd(String langCd) {
		session.put("lang-cd", langCd);
	}
	
	public String getLangNm() {
		String langNm = (String) session.get("lang-nm");
		if (StringUtils.isEmpty(langNm)) {
			langNm = "English";
		}
		return langNm;		
	}
	public void setLangNm(String langNm) {
		session.put("lang-nm", langNm);
	}
	
	private List<ListItem> buildMinimalLangList() {
		List<ListItem>  list = new ArrayList<ListItem>();
		ListItem l = new ListItem();
		l.setId("en");
		l.setName("English");
		list.add(l);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListItem> getLangList() {
		List<ListItem> list = (List<ListItem>) session.get("lang-list");
		if (list == null || list.size() == 0) {
			try {
				list = metadao.getList("language", "en");
				if (list.size() == 0) {
					list = this.buildMinimalLangList();
				}
				
			} catch (Exception e) {
				log.error("failed to retrieve language list", e);
				list = this.buildMinimalLangList();
			}
			
			setLangList(list);
		}
		
		return list;
	}
	
	public void setLangList(List<ListItem> list) {
		session.put("lang-list", list);		
	}
	
	public List<AdminTbl> getTblList() {
		@SuppressWarnings("unchecked")
		List<AdminTbl> tblList = (List<AdminTbl>) session.get(AdminConstants.SESSION_VAR_TBL_LIST);
		
		if (tblList == null) {
			tblList = metadao.getTableList(AdminConstants.TBL_TYPE_EDIT);
			setTblList(tblList);
		}
		
		return tblList;
		
	}
	public void setTblList(List<AdminTbl> tblList) {
		session.put(AdminConstants.SESSION_VAR_TBL_LIST, tblList);
	}
	
	public List<AdminTbl> getVwList() {
		@SuppressWarnings("unchecked")
		List<AdminTbl> vwList = (List<AdminTbl>) session.get(AdminConstants.SESSION_VAR_VIEW_LIST);
		
		if (vwList == null) {
			vwList = metadao.getTableList(AdminConstants.TBL_TYPE_VIEW);
			setVwList(vwList);
		}
		
		return vwList;		
	}
	
	public void setVwList(List<AdminTbl> vwList) {
		session.put(AdminConstants.SESSION_VAR_VIEW_LIST, vwList);
	}
	
	
	public List<AdminTbl> getMetaList() {
		@SuppressWarnings("unchecked")
		List<AdminTbl> metaList = (List<AdminTbl>) session.get(AdminConstants.SESSION_VAR_META_LIST);
		
		if (metaList == null) {
			metaList = metadao.getTableList(AdminConstants.TBL_TYPE_META);
			setMetaList(metaList);
		}
		
		return metaList;		
	}
	
	public void setMetaList(List<AdminTbl> metaList) {
		session.put(AdminConstants.SESSION_VAR_META_LIST, metaList);
	}
	
	protected boolean validateRecord(List<AdminCol> valcols, Map <String, String[]> data) {
		boolean valid = true;
		
		for (AdminCol col : valcols) {
			log.debug("validating column " + col.getColNm());
			if (data.containsKey(col.getColNm())) {
				String val = data.get(col.getColNm())[0];
				if (StringUtils.isEmpty(val)) {
					//test required
					if (col.isReq()) {
						addActionError(col.getDsplNm() + " is a required field.");
						valid = false;
					}
				} else {
					//test length
					if (val.length() > col.getMaxLen()) {
						addActionError(col.getDsplNm() + " may not exceed " + col.getMaxLen() + " characters.");
						valid = false;
					}
				}				
				
			} else {
				//test required
				if (col.isReq()) {
					addActionError(col.getDsplNm() + " is a required field.");
					valid = false;
				}
			}
			
		}
		
		
		return valid;
	}
}
