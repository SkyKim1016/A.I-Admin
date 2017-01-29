package com.onethefull.recipe.req;

public class AuthTokenReq {

	private String userId;
	private String authToken;
	private String newAuthToken;
	private char tokenActionType = 'A';
	private int resultCode;
	private String resultMessage;

	public AuthTokenReq() {
	}
	
	public AuthTokenReq(String uid) {
		this.setUserId(uid);
	}
	
	public AuthTokenReq(String uid, String authToken) {
		this.setUserId(uid);
		this.setAuthToken(authToken);
	}
	
	public AuthTokenReq(String uid, String authToken, char tokenActionType) {
		this.setUserId(uid);
		this.setAuthToken(authToken);
		this.setTokenActionType(tokenActionType);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}


	public String getNewAuthToken() {
		return newAuthToken;
	}

	public void setNewAuthToken(String newAuthToken) {
		this.newAuthToken = newAuthToken;
	}

	public char getTokenActionType() {
		return tokenActionType;
	}

	public void setTokenActionType(char tokenActionType) {
		this.tokenActionType = tokenActionType;
	}
	
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
}
