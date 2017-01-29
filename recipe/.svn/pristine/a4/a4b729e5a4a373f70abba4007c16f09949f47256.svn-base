package com.onethefull.recipe.req;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ModifyFavoriteStep1Req {
	private String userId;
	private List<String> list;
	private int resultCode;
	
	public ModifyFavoriteStep1Req(){}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	@JsonIgnore
	public String getListInfo() {
		if(list == null || list.isEmpty()) return null;
		
		String info = "";
		
		int i = 1;
		
		for(String id : list) {
			info += (!info.equals("")? ";" : "") + id + "|" + String.valueOf(i);
			i++;
		}
		
		return info;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}	

}
