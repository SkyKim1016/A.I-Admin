package com.onethefull.recipe.comm;

public class Result {
	public static final int SUCCESS_CODE = 0;
	public static final String SUCCESS_MESSAGE = "success";
	public static final int FAIL_CODE = -1;
	public static final String FAIL_MESSAGE = "fail";
	private int code = SUCCESS_CODE;
	private String message = SUCCESS_MESSAGE;
	public int getCode() {
		return code;
	}
	public Result setCode(int code) {
		this.code = code;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public Result setMessage(String message) {
		this.message = message;
		return this;
	}
	public void setResult(int code, String message) {
		this.code = code;
		this.message = message;		
	}
}
