package com.onethefull.recipe.comm.vo;

import com.onethefull.recipe.comm.auth.DeviceType;

public class DeviceVO {
	
	// ANDROID,IPHONE
	private DeviceType deviceType;
	private String regid;

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

}
