package com.csc.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.csc.admin.util.AdminUtils;

public class FabricFamily extends BaseModel implements IListItem {

	private String fabricFamilyCd;
	private String fabricFamilyNm;
	private String fabricFamilyDesc;

	private static final int LEN_FABRIC_FAMILY_CD = 10;
	private static final int LEN_FABRIC_FAMILY_NM = 100;
	private static final int LEN_FABRIC_FAMILY_DESC = 255;

	
	@Override
	public String getUrl() {
		return "fabricfamily";
	}

	@Override
	public String getId() {
		return fabricFamilyCd;
	}

	@Override
	public String getName() {
		return fabricFamilyNm;
	}


	@Override
	public List<String> validate() {
		ArrayList<String> msgs = new ArrayList<String>();
		
		if (AdminUtils.isEmpty(fabricFamilyCd)) { msgs.add("Fabric Family Code is required."); }
		if (AdminUtils.isEmpty(fabricFamilyNm)) { msgs.add("Fabric Family Name is required."); }
		if (AdminUtils.isEmpty(fabricFamilyDesc)) { msgs.add("Fabric Family Description is required."); }
		
		if (fabricFamilyCd != null && fabricFamilyCd.length() > LEN_FABRIC_FAMILY_CD) { msgs.add("Fabric Family Code may not exceed " + LEN_FABRIC_FAMILY_CD + " characters.");}
		if (fabricFamilyNm != null && fabricFamilyNm.length() > LEN_FABRIC_FAMILY_NM) { msgs.add("Fabric Family Name may not exceed " + LEN_FABRIC_FAMILY_NM + " characters.");}
		if (fabricFamilyDesc != null && fabricFamilyDesc.length() > LEN_FABRIC_FAMILY_DESC) { msgs.add("Fabric Family Description may not exceed " + LEN_FABRIC_FAMILY_DESC + " characters.");}
		
		return msgs;
	}

	public String getFabricFamilyCd() {
		return fabricFamilyCd;
	}

	public void setFabricFamilyCd(String fabricFamilyCd) {
		this.fabricFamilyCd = fabricFamilyCd;
	}

	public String getFabricFamilyNm() {
		return fabricFamilyNm;
	}

	public void setFabricFamilyNm(String fabricFamilyNm) {
		this.fabricFamilyNm = fabricFamilyNm;
	}

	public String getFabricFamilyDesc() {
		return fabricFamilyDesc;
	}

	public void setFabricFamilyDesc(String fabricFamilyDesc) {
		this.fabricFamilyDesc = fabricFamilyDesc;
	}

	@Override
	public boolean isLangEnabled() {
		return true;
	}

}
