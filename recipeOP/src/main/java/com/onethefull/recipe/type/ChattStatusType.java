package com.onethefull.recipe.type;

public enum ChattStatusType {
	PARTICIPATE('P'), ABSENT('A');
	
	private char code;
	
	ChattStatusType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static ChattStatusType getByCode(char val) {
		for(ChattStatusType e:ChattStatusType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return ChattStatusType.defaultChattStatusType();
	}
	
	public static ChattStatusType defaultChattStatusType() {
		return ChattStatusType.PARTICIPATE;
	}
}
