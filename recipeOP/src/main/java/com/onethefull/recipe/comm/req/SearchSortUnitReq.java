package com.onethefull.recipe.comm.req;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class SearchSortUnitReq {
	private SearchSortType sortType;
	private String sortColumn;
	private String keyCol;
	private AscDescType ascDescType;
	
	
	public SearchSortUnitReq() {
		
	}

	public SearchSortUnitReq(SearchSortType sortType) {
		this.setSortType(sortType);
	}

	public SearchSortType getSortType() {
		return sortType;
	}

	public void setSortType(SearchSortType sortType) {
		this.sortType = sortType;
	}

	@JsonIgnore
	public AscDescType getAscDescType() {
		return ascDescType;
	}

	@JsonIgnore
	public void setAscDescType(AscDescType ascDescType) {
		this.ascDescType = ascDescType;
	}
	
	@JsonIgnore	
	public AscDescType getAcsDescReverseType() {
		if(this.ascDescType.equals(AscDescType.ASC)) return AscDescType.DESC;
		return AscDescType.ASC;
	}

	@JsonIgnore
	public String getSortColumn() {
		return sortColumn;
	}

	@JsonIgnore
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	@JsonIgnore
	public String getKeyCol() {
		return keyCol;
	}

	@JsonIgnore
	public void setKeyCol(String keyCol) {
		this.keyCol = keyCol;
	}


}
