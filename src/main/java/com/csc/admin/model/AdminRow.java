package com.csc.admin.model;

import java.util.List;

public class AdminRow {

	private List<AdminCol> collist;
	private String key;
	
	public AdminRow(String key, List<AdminCol> collist) {
		this.key = key;
		this.collist = collist;
	}
	
	public List<AdminCol> getCollist() {
		return collist;
	}

	public void setColList(List<AdminCol> collist) {
		this.collist = collist;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	


}
