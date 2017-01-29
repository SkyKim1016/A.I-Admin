package com.onethefull.recipe.type;

public enum StuffExpireStatus {
	NORMAL('N'), WARNING('W'), DANGER('D'), EXPIRED('E');
	
	private char code;
	
	StuffExpireStatus(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static StuffExpireStatus getByCode(char val) {
		for(StuffExpireStatus e:StuffExpireStatus.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return StuffExpireStatus.defaultStatusType();
	}
	
	public static StuffExpireStatus defaultStatusType() {
		return StuffExpireStatus.NORMAL;
	}
}
