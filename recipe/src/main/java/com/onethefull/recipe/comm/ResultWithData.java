package com.onethefull.recipe.comm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ResultWithData {
	private final static SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final int SUCCESS_CODE = 0;
	public static final String SUCCESS_MESSAGE = "success";
	public static final int FAIL_CODE = -1;
	public static final String FAIL_MESSAGE = "fail";
	private int code = SUCCESS_CODE;
	private String guid;
	private String message = SUCCESS_MESSAGE;
	private Map<String,Object> data;
	
	public ResultWithData() {
		this.setGuid(formatDate.format(new Date()));
	}
	
	public int getCode() {
		return code;
	}
	
	public ResultWithData setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String getMessage() {
		return message;
	}
	
	public ResultWithData setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public void setResult(int code, String message) {
		this.code = code;
		this.message = message;		
	}
	
	public ResultWithData setData(Map<String, Object> data) {
		this.data = data;
		return this;
	}
	
	public ResultWithData addData(String key,Object val) {
		if(this.data == null) {
			this.data = new HashMap<String,Object>();
		}
		data.put(key, val);
		return this;
	}
	
	public Map<String,Object> getData() {
		return this.data;
	}

	public Object getData(String key) {
		if(this.data == null) {
			return null;
		}
		return this.data.get(key);
	}
	
	public static ResultWithData succcessResult() {
		return new ResultWithData();
	}
	
	public static ResultWithData failuerResult() {
		ResultWithData failureResult = new ResultWithData();
		failureResult.setCode(FAIL_CODE);
		failureResult.setMessage(FAIL_MESSAGE);
		return failureResult;
	}
	public ResultWithData renameKey(String key) {
		this.data.put(key, this.data.remove(key));
		return this;
	}
}
