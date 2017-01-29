package com.onethefull.recipe.req;

import org.springframework.web.multipart.MultipartFile;

public class RecipeReq extends UploadReq {
	private String recipeId;
	private String userId;
	private String title;
	private String content;
	private MultipartFile csv;
	
	public RecipeReq() {}
	
	public RecipeReq(String recipeId) {
		this.setRecipeId(recipeId);
	}

	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile getCsv() {
		return csv;
	}
	public void setCsv(MultipartFile csv) {
		this.csv = csv;
	}
}
