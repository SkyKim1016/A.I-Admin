package com.onethefull.recipe.vo;

import com.onethefull.recipe.type.ChattStatusType;

public class ChattVO {
	private String id;
	private String createDate;
	private int countPerson;
	private char status = 'P';
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public int getCountPerson() {
		return countPerson;
	}
	
	public void setCountPerson(int countPerson) {
		this.countPerson = countPerson;
	}
	
	public ChattStatusType getStatus() {
		return ChattStatusType.getByCode(status);
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
}