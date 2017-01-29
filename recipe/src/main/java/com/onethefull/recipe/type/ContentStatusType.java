package com.onethefull.recipe.type;

public enum ContentStatusType {
	NONE(""), NEW("N");
	
	private String code;
	
	ContentStatusType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static ContentStatusType getByCode(String val) {
		for(ContentStatusType e:ContentStatusType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return ContentStatusType.defaultContentStatusType();
	}
	
	public static ContentStatusType defaultContentStatusType() {
		return ContentStatusType.NONE;
	}
}
