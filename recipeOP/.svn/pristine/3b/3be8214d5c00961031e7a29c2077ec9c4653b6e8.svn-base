package com.onethefull.recipe.comm.req;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class SearchFilterUnitReq {
	private SearchFilterType filterType;
	private String filterColumn;
	private String keyCol;
	private AscDescType ascDescType;
	
	
	public SearchFilterUnitReq() {
		
	}

	public SearchFilterUnitReq(SearchFilterType filterType) {
		this.setFilterType(filterType);
	}

	public SearchFilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(SearchFilterType filterType) {
		this.filterType = filterType;
	}

	@JsonIgnore
	public String getFilterColumn() {
		return filterColumn;
	}

	@JsonIgnore
	public void setFilterColumn(String filterColumn) {
		this.filterColumn = filterColumn;
	}

	@JsonIgnore
	public String getKeyCol() {
		return keyCol;
	}

	@JsonIgnore
	public void setKeyCol(String keyCol) {
		this.keyCol = keyCol;
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


}
