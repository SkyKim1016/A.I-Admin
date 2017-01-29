package com.onethefull.recipe.vo;

import com.onethefull.recipe.type.ContentStatusType;

public class AnnounceVO {
	
	private String id;
	private String title;
	private String content;
	private String createDate;
	private String status;

	public AnnounceVO(){}

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public ContentStatusType getStatus() {
		return ContentStatusType.getByCode(status);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
