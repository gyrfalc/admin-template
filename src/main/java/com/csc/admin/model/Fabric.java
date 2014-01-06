package com.csc.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.csc.admin.util.AdminUtils;

public class Fabric extends BaseModel {
	
	private String fabricCd;
	private String fabricNm;
	private String fabricDesc;
	private String fabricFamilyCd;
	
	private static final int LEN_FABRIC_CD = 10;
	private static final int LEN_FABRIC_NM = 100;
	private static final int LEN_FABRIC_DESC = 255;
	private static final int LEN_FABRIC_FAMILY_CD = 10;

	@Override
	public boolean isLangEnabled() {
		return true;
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
		if (AdminUtils.isEmpty(fabricFamilyCd)) { msgs.add("Fabric Description is required."); }
		
		if (fabricCd != null && fabricCd.length() > LEN_FABRIC_CD) { msgs.add("Fabric Code may not exceed " + LEN_FABRIC_CD + " characters.");}
		if (fabricNm != null && fabricNm.length() > LEN_FABRIC_NM) { msgs.add("Fabric Name may not exceed " + LEN_FABRIC_NM + " characters.");}
		if (fabricDesc != null && fabricDesc.length() > LEN_FABRIC_DESC) { msgs.add("Fabric Description may not exceed " + LEN_FABRIC_DESC + " characters.");}
		if (fabricFamilyCd != null && fabricFamilyCd.length() > LEN_FABRIC_FAMILY_CD) { msgs.add("Fabric Family Code may not exceed " + LEN_FABRIC_FAMILY_CD + " characters.");}
		
		return msgs;
	}
	
	
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

	public String getFabricFamilyCd() {
		return fabricFamilyCd;
	}
	public void setFabricFamilyCd(String fabricFamilyCd) {
		this.fabricFamilyCd = fabricFamilyCd;
	}



}
