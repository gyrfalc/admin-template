package com.csc.admin.model;

import java.util.Date;

public class AdminNotice {

	private Long noteId;
	private String noteType;
	private String noteMsg;
	private Integer noteUsr;
	private String noteUsrNm;
	private Date noteDt;
	
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public String getNoteMsg() {
		return noteMsg;
	}
	public void setNoteMsg(String noteMsg) {
		this.noteMsg = noteMsg;
	}
	public Integer getNoteUsr() {
		return noteUsr;
	}
	public void setNoteUsr(Integer noteUsr) {
		this.noteUsr = noteUsr;
	}
	public Date getNoteDt() {
		return noteDt;
	}
	public void setNoteDt(Date noteDt) {
		this.noteDt = noteDt;
	}
	public String getNoteUsrNm() {
		return noteUsrNm;
	}
	public void setNoteUsrNm(String noteUsrNm) {
		this.noteUsrNm = noteUsrNm;
	}
	
	

}
