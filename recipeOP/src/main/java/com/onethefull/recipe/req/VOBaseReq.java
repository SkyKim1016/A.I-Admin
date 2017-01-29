package com.onethefull.recipe.req;

import com.onethefull.recipe.comm.req.PageReq;

public class VOBaseReq extends PageReq {

	private int resultCode;
	
	public VOBaseReq(){}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	
}
