package com.csc.admin.model;

import java.util.Date;
import java.util.List;

public abstract class BaseModel {
	
	protected Date modDt;
	protected Integer modBy;
	protected String modByNm;
	protected String pubStat;
	protected Date pubDt;
	
	protected String langCd;
	protected String langNm;

	public abstract String getId();
	public abstract String getUrl();
	public abstract List<String> validate();
	
	public String getPubStatNm() {
		String retval = "UNKNOWN";
		if ("PUB".equalsIgnoreCase(pubStat)) {
			retval = "PUBLISHED";
		} else if ("MOD".equalsIgnoreCase(pubStat)) {
			retval = "MODIFIED (NOT PUBLISHED)";
		} else if ("NEW".equalsIgnoreCase(pubStat)) {
			retval = "NEW (NOT PUBLISHED)";
		} else if ("TRANS".equalsIgnoreCase(pubStat)) {
			retval = "NEW (NEEDS TRANSLATION)";
		} 
		
		return retval;
	}

	
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
	public String getPubStat() {
		return pubStat;
	}
	public void setPubStat(String pubStat) {
		this.pubStat = pubStat;
	}
	public Date getPubDt() {
		return pubDt;
	}
	public void setPubDt(Date pubDt) {
		this.pubDt = pubDt;
	}
	public String getLangCd() {
		return langCd;
	}
	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}
	public String getLangNm() {
		return langNm;
	}
	public void setLangNm(String langNm) {
		this.langNm = langNm;
	}


}
