package com.onethefull.recipe.vo;

public class ChattMessageVO {
	private String id;
	private String chattId;
	private String userId;
	private String message;
	private String createDate;
	private int countRead;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getChattId() {
		return chattId;
	}
	
	public void setChattId(String chattId) {
		this.chattId = chattId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public int getCountRead() {
		return countRead;
	}
	
	public void setCountRead(int countRead) {
		this.countRead = countRead;
	}
}
