package com.onethefull.recipe.req;

import java.util.ArrayList;
import java.util.List;

import com.onethefull.recipe.comm.req.PageReq;
import com.onethefull.recipe.type.CRUDActionType;
import com.onethefull.recipe.type.EventInfoType;

public class EventReq extends PageReq {
	private final static char ITEM_DIVISION_CHAR = ';';
	private int resultCode;
	private String eventId;
	private String title;
	private String content;
	private String imageUrl1;
	private String imageUrl2;
	private String imageUrl3;
	private String linkUrl;
	private String startDate;
	private String endDate;
	private CRUDActionType type = CRUDActionType.defaultCRUDActionType();
	private EventInfoType eventType = EventInfoType.defaultEventInfoType();
	private List<String> itemIdList;
	
	public EventReq() {
	}

	public EventReq(String eventId) {
		super();
		this.eventId = eventId;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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

	public CRUDActionType getType() {
		return type;
	}

	public void setType(CRUDActionType type) {
		this.type = type;
	}

	public EventInfoType getEventType() {
		return eventType;
	}

	public void setEventType(EventInfoType eventType) {
		this.eventType = eventType;
	}
	
	public List<String> getItemIdList() {
		return itemIdList;
	}
	
	public void setItemIdList(List<String> itemIdList) {
		this.itemIdList = itemIdList;
	}
	
	public void addItemId(String itemId) {
		if(this.itemIdList == null) {
			this.itemIdList = new ArrayList<String>();
		}
		if(!this.itemIdList.contains(itemId)) {
			this.itemIdList.add(itemId);
		}
	}
	
	public void removeItemId(String itemId) {
		if(this.itemIdList != null && !this.itemIdList.isEmpty()) {
			if(this.itemIdList.contains(itemId)) {
				this.itemIdList.remove(itemId);
			}
		}
	}
	
	public String getItemIds() {
		StringBuffer itemIds = new StringBuffer();
		if(this.itemIdList != null && !this.itemIdList.isEmpty()) {
			for(String itemId : this.itemIdList) {
				itemIds.append(itemId);
				itemIds.append(ITEM_DIVISION_CHAR);
			}
		}
		return itemIds.toString();
	}
}
