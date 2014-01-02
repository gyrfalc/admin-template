package com.csc.admin.model;

public class ListItem implements IListItem {
	
	private String id;
	private String name;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
