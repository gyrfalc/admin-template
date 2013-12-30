package com.csc.admin.model;

import java.util.Date;
import java.util.List;

public abstract class BaseModel {
	
	protected Date modDt;
	protected Integer modBy;
	protected String modByNm;

	public abstract String getId();
	public abstract String getUrl();
	public abstract List<String> validate();

	
	public int getUniqueStamp() {
		return hashCode();
	}



	public Date getModDt() {
		return modDt;
	}



	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}



	public Integer getModBy() {
		return modBy;
	}



	public void setModBy(Integer modBy) {
		this.modBy = modBy;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modBy == null) ? 0 : modBy.hashCode());
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
		return result;
	}
	public String getModByNm() {
		return modByNm;
	}
	public void setModByNm(String modByNm) {
		this.modByNm = modByNm;
	}


}
