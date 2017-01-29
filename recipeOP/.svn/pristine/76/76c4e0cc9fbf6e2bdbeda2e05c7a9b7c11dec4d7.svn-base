package com.onethefull.recipe.type;

public enum UserStatusType {
	INIT(""), BEFOREFIRSTLOGIN("B"), BEFORESET("S"), AFTERSET("F"), ACTIVE("A");
	
	private String code;
	
	UserStatusType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static UserStatusType getByCode(String val) {
		for(UserStatusType e:UserStatusType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return UserStatusType.defaultUserStatusType();
	}
	
	public static UserStatusType defaultUserStatusType() {
		return UserStatusType.INIT;
	}
}
