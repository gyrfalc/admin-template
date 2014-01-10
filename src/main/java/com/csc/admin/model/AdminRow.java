package com.csc.admin.model;

import java.util.List;

public class AdminRow {

	private List<AdminCol> collist;
	private String keyVal;
	
	public AdminRow(String keyVal, List<AdminCol> collist) {
		this.keyVal = keyVal;
		this.collist = collist;
	}
	
	public List<AdminCol> getCollist() {
		return collist;
	}

	public void setColList(List<AdminCol> collist) {
		this.collist = collist;
	}

	public String getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}
	


}
