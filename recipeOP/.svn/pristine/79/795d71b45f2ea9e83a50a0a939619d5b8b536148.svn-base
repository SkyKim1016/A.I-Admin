package com.onethefull.recipe.type;

public enum RecommendType {
	NONE(""), CREATED("C"), HEALTH("HT"), TASTE("TA"), POPULAR("PO") ;
	
	private String code;
	
	RecommendType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static RecommendType getByCode(String val) {
		for(RecommendType e:RecommendType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return RecommendType.defaultRecommendType();
	}
	
	public static RecommendType defaultRecommendType() {
		return RecommendType.NONE;
	}
}
