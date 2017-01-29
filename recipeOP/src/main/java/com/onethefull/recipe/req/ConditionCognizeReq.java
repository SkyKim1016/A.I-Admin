package com.onethefull.recipe.req;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.type.CognizeActionType;

public class ConditionCognizeReq extends CognizeReq {
	private final static String DIV_FORMAT = "|";
	private int count;
	private String imageUrl;
	private CognizeActionType actionType = CognizeActionType.defaultStatusType();
	private List<String> stuffList;
	
	public ConditionCognizeReq() {
		super();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public CognizeActionType getActionType() {
		return actionType;
	}

	public void setActionType(CognizeActionType actionType) {
		this.actionType = actionType;
	}

	public List<String> getStuffList() {
		return stuffList;
	}

	public void setStuffList(List<String> stuffList) {
		this.stuffList = stuffList;
	}
	
	@JsonIgnore
	public String getStuffIds() {
		StringBuffer stuffIdsBuffer = new StringBuffer();
		if(this.stuffList != null && !this.stuffList.isEmpty()) {
			for(String stuff : this.stuffList) {
				if(stuffIdsBuffer.length() != 0) {
					stuffIdsBuffer.append(DIV_FORMAT);
				}
				stuffIdsBuffer.append(stuff);
			}
		}
		return stuffIdsBuffer.toString();
	}
	
	@JsonIgnore
	public void addStuff(String stuff) {
		if(this.stuffList == null) {
			this.stuffList = new ArrayList<String>();
		}
		if(!this.stuffList.contains(stuff)) {
			this.stuffList.add(stuff);
		}
	}
	
	@JsonIgnore
	public void removeStuff(String stuff) {
		if(this.stuffList != null && !this.stuffList.isEmpty()) {
			this.stuffList.remove(stuff);
		}
	}
}
