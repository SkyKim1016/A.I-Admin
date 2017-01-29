package com.onethefull.recipe.type;

public enum FridgeIngrType {
	INSERT("I"), UPDATE("U"), DELETE("D") ;
	
	private String code;
	
	FridgeIngrType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static FridgeIngrType getByCode(String val) {
		for(FridgeIngrType e:FridgeIngrType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return FridgeIngrType.defaultFridgeIngrType();
	}
	
	public static FridgeIngrType defaultFridgeIngrType() {
		return FridgeIngrType.INSERT;
	}
}
