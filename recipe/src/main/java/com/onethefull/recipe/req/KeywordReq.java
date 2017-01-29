package com.onethefull.recipe.req;


public class KeywordReq {
	private String keyVar;
	private String keyValue;
	private String keyCol;
	private String keyType;
	
	
	public KeywordReq() {
		
	}

	public KeywordReq(String keyVar, String keyValue) {
		this.setKeyVar(keyVar);
		this.setKeyValue(keyValue);
	}

	public String getKeyVar() {
		return keyVar;
	}

	public void setKeyVar(String keyVar) {
		this.keyVar = keyVar;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getKeyCol() {
		return keyCol;
	}

	public void setKeyCol(String keyCol) {
		this.keyCol = keyCol;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
}
