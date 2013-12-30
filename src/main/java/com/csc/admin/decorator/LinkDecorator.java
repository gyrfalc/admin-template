package com.csc.admin.decorator;

import org.displaytag.decorator.TableDecorator;

import com.csc.admin.model.BaseModel;

public class LinkDecorator extends TableDecorator {
	
	public String getId()
	{
	        BaseModel lObject= (BaseModel) getCurrentRowObject();
	        return "<a href=\"view/" + lObject.getId() + "\">" + lObject.getId() + "</a>";
	}

}
