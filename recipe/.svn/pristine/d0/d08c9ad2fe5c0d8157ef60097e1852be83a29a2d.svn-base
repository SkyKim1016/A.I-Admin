package com.onethefull.recipe.vo;

import com.onethefull.recipe.type.FriendshipStatusType;

public class FriendVO {
	
	private String id;
	private String name;
	private String imageOriginalUrl;
	private String imageThumbUrl;
	private String createDate;
	private String status;
	
	public FriendVO() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageOriginalUrl() {
		return imageOriginalUrl;
	}
	public void setImageOriginalUrl(String imageOriginalUrl) {
		this.imageOriginalUrl = imageOriginalUrl;
	}
	public String getImageThumbUrl() {
		return imageThumbUrl;
	}
	public void setImageThumbUrl(String imageThumbUrl) {
		this.imageThumbUrl = imageThumbUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public FriendshipStatusType getStatus() {
		return FriendshipStatusType.getByCode(status);
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
