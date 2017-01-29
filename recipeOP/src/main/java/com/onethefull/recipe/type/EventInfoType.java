package com.onethefull.recipe.type;

public enum EventInfoType {
	RECIPE('R');
	
	private char code;
	
	EventInfoType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static EventInfoType getByCode(char val) {
		for(EventInfoType e:EventInfoType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return EventInfoType.defaultEventInfoType();
	}
	
	public static EventInfoType defaultEventInfoType() {
		return EventInfoType.RECIPE;
	}
}
