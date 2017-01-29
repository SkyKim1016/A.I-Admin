package com.onethefull.recipe.type;

public enum UserGenderType {
	NONE("N"), MALE("M"), FEMALE("F") ;
	
	private String code;
	
	UserGenderType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static UserGenderType getByCode(String val) {
		for(UserGenderType e:UserGenderType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return UserGenderType.defaultUserGenderType();
	}
	
	public static UserGenderType defaultUserGenderType() {
		return UserGenderType.MALE;
	}
}
