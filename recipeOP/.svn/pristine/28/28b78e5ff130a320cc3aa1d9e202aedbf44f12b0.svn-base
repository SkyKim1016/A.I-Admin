package com.onethefull.recipe.type;

public enum CognizeStatusType {
	PREPARE('P'), DELETE('D'), COMPLETE('C'), TRNASFER('T');
	
	private char code;
	
	CognizeStatusType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static CognizeStatusType getByCode(char val) {
		for(CognizeStatusType e:CognizeStatusType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return CognizeStatusType.defaultStatusType();
	}
	
	public static CognizeStatusType defaultStatusType() {
		return CognizeStatusType.PREPARE;
	}
}
