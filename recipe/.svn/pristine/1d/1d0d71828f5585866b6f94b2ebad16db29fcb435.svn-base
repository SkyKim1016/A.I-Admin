package com.onethefull.recipe.comm.req;

public enum PushSendType {
	COGNIZE("CT"), FRIENDREQUEST("FR"), FRIENDREQUESTACCEPT("FF"), FRIENDREQUESTREJECT("FJ");
	
	private String code;
	
	PushSendType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static PushSendType getByCode(String val) {
		for(PushSendType e:PushSendType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return PushSendType.defaultPushSendType();
	}
	
	public static PushSendType defaultPushSendType() {
		return PushSendType.COGNIZE;
	}
}
