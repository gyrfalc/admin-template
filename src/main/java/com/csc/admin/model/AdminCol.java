package com.csc.admin.model;

import java.util.Date;

public class AdminCol {
	private String tblNm;
	private String colNm;
	private String dsplNm;
	private int dsplOrd;
	private String dataType;
	private String sortInd;
	private int sortOrd;
	private String sortDir;
	private String srchInd;
	private String keyInd;
	private String metaInd;
	private String metaType;
	private String renderType;
	private String renderParams;
	
	private Date valDate;
	private String valString;
	private Integer valInt;
	private Double valDouble;
	
	public String getVal() {
		if (dataType.equals("char")) { return valString; }
		if (dataType.equals("date")) { return valDate.toString(); }
		if (dataType.equals("int")) { return valInt.toString(); }
		if (dataType.equals("dbl")) { return valDouble.toString(); }
		
		return null;
	}
	
	public AdminCol clone() {
		AdminCol col = new AdminCol();
		col.setTblNm(this.getTblNm());
		col.setColNm(this.getColNm());
		col.setDsplNm(this.getDsplNm());
		col.setDsplOrd(this.getDsplOrd());
		col.setDataType(this.getDataType());
		col.setSortInd(this.getSortInd());
		col.setSortOrd(this.getSortOrd());
		col.setSortDir(this.getSortDir());
		col.setSrchInd(this.getSrchInd());
		col.setKeyInd(this.getKeyInd());
		col.setMetaInd(this.getMetaInd());
		col.setMetaType(this.getMetaType());
		col.setRenderType(this.getRenderType());
		col.setRenderParams(this.getRenderParams());
		
		return col;
	}
	
	public String getTblNm() {
		return tblNm;
	}
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	public String getColNm() {
		return colNm;
	}
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	public String getDsplNm() {
		return dsplNm;
	}
	public void setDsplNm(String dsplNm) {
		this.dsplNm = dsplNm;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getSortOrd() {
		return sortOrd;
	}
	public void setSortOrd(int sortOrd) {
		this.sortOrd = sortOrd;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	public String getKeyInd() {
		return keyInd;
	}
	public void setKeyInd(String keyInd) {
		this.keyInd = keyInd;
	}
	public String getMetaInd() {
		return metaInd;
	}
	public void setMetaInd(String metaInd) {
		this.metaInd = metaInd;
	}
	public String getMetaType() {
		return metaType;
	}
	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}
	public int getDsplOrd() {
		return dsplOrd;
	}
	public void setDsplOrd(int dsplOrd) {
		this.dsplOrd = dsplOrd;
	}
	public String getSrchInd() {
		return srchInd;
	}
	public void setSrchInd(String srchInd) {
		this.srchInd = srchInd;
	}
	public String getSortInd() {
		return sortInd;
	}
	public void setSortInd(String sortInd) {
		this.sortInd = sortInd;
	}
	public String getRenderType() {
		return renderType;
	}
	public void setRenderType(String renderType) {
		this.renderType = renderType;
	}
	public String getRenderParams() {
		return renderParams;
	}
	public void setRenderParams(String renderParams) {
		this.renderParams = renderParams;
	}
	public Date getValDate() {
		return valDate;
	}
	public void setValDate(Date valDate) {
		this.valDate = valDate;
	}
	public String getValString() {
		return valString;
	}
	public void setValString(String valString) {
		this.valString = valString;
	}
	public Integer getValInt() {
		return valInt;
	}
	public void setValInt(Integer valInt) {
		this.valInt = valInt;
	}
	public Double getValDouble() {
		return valDouble;
	}
	public void setValDouble(Double valDouble) {
		this.valDouble = valDouble;
	}
}
