package com.onethefull.recipe.comm.req;

import java.util.List;

public class SearchSortReq {
	private List<SearchSortUnitReq> conditions;
	
	public SearchSortReq() {
	}

	public SearchSortReq(List<SearchSortUnitReq> list) {
		this.setConditions(list);
	}

	public List<SearchSortUnitReq> getConditions() {
		return conditions;
	}

	public void setConditions(List<SearchSortUnitReq> conditions) {
		this.conditions = conditions;
	}


}
