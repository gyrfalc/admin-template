package com.csc.admin.model;

import java.io.Serializable;

public class ListItem implements IListItem, Serializable {

	private static final long serialVersionUID = 1L;
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
