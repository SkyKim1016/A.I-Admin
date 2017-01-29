package com.onethefull.recipe.type;

public enum UploadType {
	RECIPE('R'), CONDITION('C'), PROFILE('P');
	
	private char code;
	
	UploadType(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static UploadType getByCode(char val) {
		for(UploadType e:UploadType.values()) {
			if(e.getCode() == val) {
				return e;
			}
		}
		return UploadType.defaultUploadType();
	}
	
	public static UploadType defaultUploadType() {
		return UploadType.RECIPE;
	}
}
