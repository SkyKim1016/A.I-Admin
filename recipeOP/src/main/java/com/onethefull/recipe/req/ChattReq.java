package com.onethefull.recipe.req;

import com.onethefull.recipe.type.ChattActionType;

public class ChattReq extends VOBaseReq {
	private String id;
	private String userId;
	private ChattActionType type = ChattActionType.defaultChattActionType();
	private String receiveUserId;
	private String message;
	private int countRead;
	
	public ChattReq() {
	}
	
	public ChattReq(String userId) {
		super();
		this.userId = userId;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public ChattActionType getType() {
		return type;
	}

	public void setType(ChattActionType type) {
		this.type = type;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}
	
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public int getCountRead() {
		return countRead;
	}

	public void setCountRead(int countRead) {
		this.countRead = countRead;
	}
}
