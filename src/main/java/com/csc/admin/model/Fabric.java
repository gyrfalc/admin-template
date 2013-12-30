package com.csc.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.csc.admin.util.AdminUtils;

public class Fabric extends BaseModel {
	
	private String fabricCd;
	private String fabricNm;
	private String fabricDesc;
	
	public String getFabricCd() {
		return fabricCd;
	}
	public void setFabricCd(String fabricCd) {
		this.fabricCd = fabricCd;
	}
	public String getFabricNm() {
		return fabricNm;
	}
	public void setFabricNm(String fabricNm) {
		this.fabricNm = fabricNm;
	}
	public String getFabricDesc() {
		return fabricDesc;
	}
	public void setFabricDesc(String fabricDesc) {
		this.fabricDesc = fabricDesc;
	}
	@Override
	public String getId() {
		return fabricCd;
	}
	@Override
	public String getUrl() {
		return "fabric";
	}
	@Override
	public List<String> validate() {
		ArrayList<String> msgs = new ArrayList<String>();
		
		if (AdminUtils.isEmpty(fabricCd)) { msgs.add("Fabric Code is required."); }
		if (AdminUtils.isEmpty(fabricNm)) { msgs.add("Fabric Name is required."); }
		if (AdminUtils.isEmpty(fabricDesc)) { msgs.add("Fabric Description is required."); }
		
		return msgs;
	}


}
