package com.onethefull.recipe.type;

public enum ChattActionType {
	CREATE('C'), EXIT('E'), SEND('S');
	
	private char code;
	
	ChattActionType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static ChattActionType getByCode(char val) {
		for(ChattActionType e:ChattActionType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return ChattActionType.defaultChattActionType();
	}
	
	public static ChattActionType defaultChattActionType() {
		return ChattActionType.CREATE;
	}
}
