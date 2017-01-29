package com.onethefull.recipe.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.onethefull.recipe.type.CognizeStatusType;
import com.onethefull.recipe.type.CognizeViewStatusType;

public class CognizeVO {
private final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	private String id;
	private String userId;
	private CognizeStatusType status;
	private CognizeViewStatusType viewStatus;
	private Date requestDate;
	
	public CognizeVO() {
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

	public CognizeStatusType getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = CognizeStatusType.getByCode(status);
	}

	public CognizeViewStatusType getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(char viewStatus) {
		this.viewStatus = CognizeViewStatusType.getByCode(viewStatus);
	}

	public String getRequestDate() {
		return df.format(requestDate);
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
}
