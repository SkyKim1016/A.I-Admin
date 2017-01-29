package com.onethefull.recipe.type;

public enum CRUDActionType {
	CREATE('C'), UPDATE('U'), DELETE('D'), READ('R');
	
	private char code;
	
	CRUDActionType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static CRUDActionType getByCode(char val) {
		for(CRUDActionType e:CRUDActionType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return CRUDActionType.defaultCRUDActionType();
	}
	
	public static CRUDActionType defaultCRUDActionType() {
		return CRUDActionType.CREATE;
	}
}
