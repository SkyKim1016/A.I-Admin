package com.onethefull.recipe.comm.req;


public enum SearchSortType {
	CREATED("창작요리"), POPULAR("인기순"), TASTE("취향순"), HEALTH("건강순");
	
	private String code;
	
	SearchSortType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	public static SearchSortType getByCode(String val) {
		for(SearchSortType e:SearchSortType.values()) {
			if(e.getCode().equals(val)) {
				return e;
			}
		}
		return SearchSortType.defaultSearchSortType();
	}
	
	public static SearchSortType defaultSearchSortType() {
		return SearchSortType.TASTE;
	}
	
}