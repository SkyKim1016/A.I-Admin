package com.onethefull.recipe.type;

public enum AdminActionType {
	INSERT('I'), APPEND('A'), DELETE('D'), UPDATE('U'), CHANGE('C');
	
	private char code;
	
	AdminActionType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static AdminActionType getByCode(char val) {
		for(AdminActionType e:AdminActionType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return AdminActionType.defaultAdminActionType();
	}
	
	public static AdminActionType defaultAdminActionType() {
		return AdminActionType.INSERT;
	}
}
