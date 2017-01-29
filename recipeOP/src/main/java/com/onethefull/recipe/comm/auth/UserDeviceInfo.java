package com.onethefull.recipe.comm.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDeviceInfo {

	private String userId;
	private DeviceType lastDevice = DeviceType.NONE;  // default 
	private Map<String,DeviceInfo> deviceInfos = new HashMap<String,DeviceInfo>(2);
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DeviceType getLastDevice() {
		return lastDevice;
	}

	public void setLastDevice(DeviceType lastDevice) {
		this.lastDevice = lastDevice;
	}

	public List<DeviceInfo> getDeviceInfos() {
		return new ArrayList<DeviceInfo>(deviceInfos.values());
	}
	
	public void addDevice(DeviceInfo DeviceInfo) {
		DeviceType type = DeviceInfo.getDeviceType();
		if(type == DeviceType.ANDROID || type == DeviceType.IPHONE) {
			deviceInfos.put(type.toString(), DeviceInfo);
		}  else {
			throw new IllegalArgumentException(String.format("%s is not allowed type.", type));
		}
	}


	public void setDeviceInfos(Map<String, DeviceInfo> deviceInfos) {
		this.deviceInfos = deviceInfos;
	}
	
}
