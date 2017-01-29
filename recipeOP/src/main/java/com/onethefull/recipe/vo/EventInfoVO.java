package com.onethefull.recipe.vo;

import com.onethefull.recipe.type.EventInfoType;

public class EventInfoVO {
	private String id;
	private String title;
	private String content;
	private String imageUrl1;
	private String imageUrl2;
	private String imageUrl3;
	private String linkUrl;
	private String startDate;
	private String endDate;
	private char type = EventInfoType.defaultEventInfoType().getCode();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImageUrl1() {
		return imageUrl1;
	}
	
	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}
	
	public String getImageUrl2() {
		return imageUrl2;
	}
	
	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}
	
	public String getImageUrl3() {
		return imageUrl3;
	}
	
	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}
	
	public String getLinkUrl() {
		return linkUrl;
	}
	
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public EventInfoType getType() {
		return EventInfoType.getByCode(type);
	}
	
	public void setType(char type) {
		this.type = type;
	}
}
