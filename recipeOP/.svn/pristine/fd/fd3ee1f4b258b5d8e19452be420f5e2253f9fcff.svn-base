package com.onethefull.recipe.vo;

import com.onethefull.recipe.type.NotiActionType;
import com.onethefull.recipe.type.NotiStatusType;

public class NotiVO {
	
	private String id;
	private String userId;
	private String content;
	private String info;
	private String senderName;
	private String senderId;
	private String imageUrl;
	private String createDate;
	private String actionType;
	private char status;

	public NotiVO(){}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public NotiActionType getActionType() {
		return NotiActionType.getByCode(actionType);
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public NotiStatusType getStatus() {
		return NotiStatusType.getByCode(status);
	}

	public void setStatus(char status) {
		this.status = status;
	}

	
}
