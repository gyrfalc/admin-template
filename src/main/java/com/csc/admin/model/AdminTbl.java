package com.csc.admin.model;

public class AdminTbl {
	private String tblNm;
	private String dsplNm;
	private String shortDesc;
	private String viewInd;
	private String viewNm;
	private String langInd;
	private String sortInd;
	
	public boolean hasView() {
		return "Y".equalsIgnoreCase(viewInd);
	}
	public boolean hasLang() {
		return "Y".equalsIgnoreCase(langInd);
	}
	public boolean hasSortCols() {
		return "Y".equalsIgnoreCase(sortInd);
	}
	
	public String getTblNm() {
		return tblNm;
	}
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	public String getDsplNm() {
		return dsplNm;
	}
	public void setDsplNm(String dsplNm) {
		this.dsplNm = dsplNm;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getViewNm() {
		return viewNm;
	}
	public void setViewNm(String viewNm) {
		this.viewNm = viewNm;
	}
	public String getViewInd() {
		return viewInd;
	}
	public void setViewInd(String viewInd) {
		this.viewInd = viewInd;
	}
	public String getLangInd() {
		return langInd;
	}
	public void setLangInd(String langInd) {
		this.langInd = langInd;
	}
	public String getSortInd() {
		return sortInd;
	}
	public void setSortInd(String sortInd) {
		this.sortInd = sortInd;
	}

}
