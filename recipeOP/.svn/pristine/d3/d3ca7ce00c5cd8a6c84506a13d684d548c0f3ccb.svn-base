package com.onethefull.recipe.type;

public enum CognizeViewStatusType {
	NONE('N'), VIEW('V');
	
	private char code;
	
	CognizeViewStatusType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static CognizeViewStatusType getByCode(char val) {
		for(CognizeViewStatusType e:CognizeViewStatusType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return CognizeViewStatusType.defaultStatusType();
	}
	
	public static CognizeViewStatusType defaultStatusType() {
		return CognizeViewStatusType.NONE;
	}
}
