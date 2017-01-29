package com.onethefull.recipe.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.type.StuffExpireStatus;

public class RecipeIngrVOwithDday {
	private String ingrCategoryId;
	private String ingrCategoryName;
	private String ingrCategoryImageUrl;	
	private String ingredientId;
	private String ingredientName;
	private String ingredientQnt;
	private String ingredientDday;
	private String ingredientImageUrl;
	private StuffExpireStatus expStatus = StuffExpireStatus.defaultStatusType();

	public RecipeIngrVOwithDday() {
	}

	public RecipeIngrVOwithDday(String ingredientId, String ingredientName, String ingredientQnt, String ingredientDday,
			String ingredientImageUrl, StuffExpireStatus expStatus) {
		super();
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.ingredientQnt = ingredientQnt;
		this.ingredientDday = ingredientDday;
		this.setIngredientImageUrl(ingredientImageUrl);
		this.expStatus = expStatus;
	}

	@JsonIgnore
	public String getIngrCategoryId() {
		return ingrCategoryId;
	}

	@JsonIgnore
	public void setIngrCategoryId(String ingrCategoryId) {
		this.ingrCategoryId = ingrCategoryId;
	}

	@JsonIgnore
	public String getIngrCategoryName() {
		return ingrCategoryName;
	}

	@JsonIgnore
	public void setIngrCategoryName(String ingrCategoryName) {
		this.ingrCategoryName = ingrCategoryName;
	}

	@JsonIgnore
	public String getIngrCategoryImageUrl() {
		return ingrCategoryImageUrl;
	}

	@JsonIgnore
	public void setIngrCategoryImageUrl(String ingrCategoryImageUrl) {
		this.ingrCategoryImageUrl = ingrCategoryImageUrl;
	}

	public String getIngredientQnt() {
		return ingredientQnt;
	}

	public String getIngredientDday() {
		return ingredientDday;
	}

	public void setIngredientDday(String ingredientDday) {
		this.ingredientDday = ingredientDday;
	}

	public String getIngredientImageUrl() {
		return ingredientImageUrl;
	}

	public void setIngredientImageUrl(String ingredientImageUrl) {
		this.ingredientImageUrl = ingredientImageUrl;
	}

	public void setIngredientQnt(String ingredientQnt) {
		this.ingredientQnt = ingredientQnt;
	}

	public String getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public StuffExpireStatus getExpStatus() {
		return expStatus;
	}

	public void setExpStatus(StuffExpireStatus expStatus) {
		this.expStatus = expStatus;
	}
}
