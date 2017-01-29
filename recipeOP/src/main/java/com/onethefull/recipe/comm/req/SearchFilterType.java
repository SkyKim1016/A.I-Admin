package com.onethefull.recipe.comm.req;


public enum SearchFilterType {
	CREATED("창작요리"), TASTE("취향순"), HEALTH("건강순");
	
	private String code;
	
	SearchFilterType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	public static SearchFilterType getByCode(String val) {
		for(SearchFilterType e:SearchFilterType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return SearchFilterType.defaultSearchSortType();
	}
	
	public static SearchFilterType defaultSearchSortType() {
		return SearchFilterType.TASTE;
	}
	
}