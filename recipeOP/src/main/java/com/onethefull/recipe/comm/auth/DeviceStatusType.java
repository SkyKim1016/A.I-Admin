package com.onethefull.recipe.comm.auth;

public enum DeviceStatusType {
	USED('Y'), NONE('N');
	
	private char code;
	
	DeviceStatusType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static DeviceStatusType getByCode(char val) {
		for(DeviceStatusType e:DeviceStatusType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return DeviceStatusType.defaultDeviceStatusType();
	}
	
	public static DeviceStatusType defaultDeviceStatusType() {
		return DeviceStatusType.USED;
	}
}
