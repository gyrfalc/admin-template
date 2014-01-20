package com.csc.admin.model;

import java.io.Serializable;

public class AdminTbl implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tblNm;
	private String tblType;
	private String dsplNm;
	private String shortDesc;
	private String viewInd;
	private String viewNm;
	private String langInd;
	private String langColNm;
	private String sortInd;
	private String urlNm;
	private String surrogateKeyNm;
	private String instrAdd;
	private String instrEdit;
	private String instrDel;
	
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
	public String getLangColNm() {
		return langColNm;
	}
	public void setLangColNm(String langColNm) {
		this.langColNm = langColNm;
	}
	public String getUrlNm() {
		return urlNm;
	}
	public void setUrlNm(String urlNm) {
		this.urlNm = urlNm;
	}
	public String getSurrogateKeyNm() {
		return surrogateKeyNm;
	}
	public void setSurrogateKeyNm(String surrogateKeyNm) {
		this.surrogateKeyNm = surrogateKeyNm;
	}
	public String getInstrAdd() {
		return instrAdd;
	}
	public void setInstrAdd(String instrAdd) {
		this.instrAdd = instrAdd;
	}
	public String getInstrEdit() {
		return instrEdit;
	}
	public void setInstrEdit(String instrEdit) {
		this.instrEdit = instrEdit;
	}
	public String getInstrDel() {
		return instrDel;
	}
	public void setInstrDel(String instrDel) {
		this.instrDel = instrDel;
	}
	public String getTblType() {
		return tblType;
	}
	public void setTblType(String tblType) {
		this.tblType = tblType;
	}

}
