package com.onethefull.recipe.type;

public enum NotiStatusType {
	NEW('R'), CONFIRMED('C');
	
	private char code;
	
	NotiStatusType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static NotiStatusType getByCode(char val) {
		for(NotiStatusType e:NotiStatusType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return NotiStatusType.defaultNotiStatusType();
	}
	
	public static NotiStatusType defaultNotiStatusType() {
		return NotiStatusType.NEW;
	}
}
