package com.onethefull.recipe.comm.req;


public enum SearchSortType {
	NAME("이름순"), POPULAR("인기순"), LATEST("최신순"), CREATED("창작순"), TASTE("취향순"), HEALTH("건강순");
	
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