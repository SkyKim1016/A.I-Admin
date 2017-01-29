package com.onethefull.recipe.comm.req;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageReq {
	protected int pageSize = 10;
	protected int pageNum = 1;
	protected SearchFilterReq filterReq;
	protected SearchSortReq sortReq;
	
	public PageReq() {
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize > 0) this.pageSize = pageSize;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum > 0) this.pageNum = pageNum;
	}

	@JsonIgnore
	public int getStartNum() {
		return (this.pageNum - 1) * this.pageSize;
	}

	public SearchSortReq getSortReq() {
		return sortReq;
	}

	public void setSortReq(SearchSortReq sortReq) {
		this.sortReq = sortReq;
	}

	public SearchFilterReq getFilterReq() {
		return filterReq;
	}

	public void setFilterReq(SearchFilterReq filterReq) {
		this.filterReq = filterReq;
	}
}
