package com.onethefull.recipe.comm.req;

import com.onethefull.recipe.req.KeywordReq;

public class SearchReq extends PageReq {

	private int resultCode;
	protected KeywordReq keywordReq;
	
	public SearchReq() {
		super();
	}
	
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	
	public KeywordReq getKeywordReq() {
		return keywordReq;
	}

	public void setKeywordReq(KeywordReq keywordReq) {
		this.keywordReq = keywordReq;
	}
	
}
