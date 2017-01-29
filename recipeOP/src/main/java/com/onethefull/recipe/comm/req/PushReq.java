package com.onethefull.recipe.comm.req;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.comm.vo.DeviceVO;

public class PushReq {
	private static enum PushType {
		NOTICE;
		
		public static PushType defaultPushType() {
			return PushType.NOTICE;
		}
	}
	
	private String title;
	private String message;
	private PushType pushType = PushType.defaultPushType();
	private List<DeviceVO> devices;
	private List<String> userIdList;
	
	public PushReq() {
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public PushType getPushType() {
		return pushType;
	}
	
	public void setPushType(PushType pushType) {
		this.pushType = pushType;
	}
	
	public List<DeviceVO> getDevices() {
		return devices;
	}
	
	public void setDevices(List<DeviceVO> devices) {
		this.devices = devices;
	}

	@JsonIgnore
	public void addDevice(DeviceVO deviceVO) {
		if(devices == null) {
			devices = new ArrayList<DeviceVO>();
		}
		if(!devices.contains(deviceVO)) {
			devices.add(deviceVO);
		}
	}
	
	@JsonIgnore
	public void removeDevice(DeviceVO deviceVO) {
		if(devices == null) {
			devices = new ArrayList<DeviceVO>();
		}
		if(devices.size() > 0 && devices.contains(deviceVO)) {
			devices.remove(deviceVO);
		}
	}
	
	@JsonIgnore
	public List<String> getUserIdList() {
		return userIdList;
	}

	@JsonIgnore
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}
	
	@JsonIgnore
	public void addUserId(String userId) {
		if(userIdList == null) {
			userIdList = new ArrayList<String>();
		}
		if(!userIdList.contains(userId)) {
			userIdList.add(userId);
		}
	}
	
	@JsonIgnore
	public void removeUserId(String userId) {
		if(userIdList == null) {
			userIdList = new ArrayList<String>();
		}
		if(userIdList.size() > 0 && userIdList.contains(userId)) {
			userIdList.remove(userId);
		}
	}
}
