package com.onethefull.recipe.type;

public enum CognizeActionType {
	NEW('N'), VIEW('V'), APPEND('A'), OMIT('O'), TRANSFER('T'), DELETE('D'), COMPLETE('C');
	
	private char code;
	
	CognizeActionType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static CognizeActionType getByCode(char val) {
		for(CognizeActionType e:CognizeActionType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return CognizeActionType.defaultStatusType();
	}
	
	public static CognizeActionType defaultStatusType() {
		return CognizeActionType.NEW;
	}
}
