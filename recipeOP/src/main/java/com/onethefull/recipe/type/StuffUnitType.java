package com.onethefull.recipe.type;

public enum StuffUnitType {
	COUNT("CT"), LENGTH("LN"), SEQUARE("SQ"), CUBIC("CB"), CAPACITY("CP"), WEIGHT("WT");
	
	private String code;
	
	StuffUnitType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static StuffUnitType getByCode(String val) {
		for(StuffUnitType e:StuffUnitType.values()) {
			if(e.getCode().equalsIgnoreCase(val)) {
				return e;
			}
		}
		return StuffUnitType.defaultStuffUnitType();
	}
	
	public static StuffUnitType defaultStuffUnitType() {
		return StuffUnitType.COUNT;
	}
}
