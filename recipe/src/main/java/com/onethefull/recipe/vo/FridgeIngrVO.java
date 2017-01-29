package com.onethefull.recipe.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.type.StuffExpireStatus;

public class FridgeIngrVO {
	private String ingrCategoryId;
	private String ingrCategoryName;
	private String ingrCategoryImageUrl;
	private String ingredientId;
	private String ingredientName;
	private String ingredientDday;
	private String ingredientImageUrl;
	private int qty;
	private String unit;
	private String expirationDate;
	private StuffExpireStatus expStatus = StuffExpireStatus.defaultStatusType();
	
	public FridgeIngrVO() {}
	
	public String getIngrCategoryId() {
		return ingrCategoryId;
	}
	public void setIngrCategoryId(String ingrCategoryId) {
		this.ingrCategoryId = ingrCategoryId;
	}
	public String getIngrCategoryName() {
		return ingrCategoryName;
	}
	public void setIngrCategoryName(String ingrCategoryName) {
		this.ingrCategoryName = ingrCategoryName;
	}
	public String getIngrCategoryImageUrl() {
		return ingrCategoryImageUrl;
	}

	public void setIngrCategoryImageUrl(String ingrCategoryImageUrl) {
		this.ingrCategoryImageUrl = ingrCategoryImageUrl;
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
	
	public String getIngredientQnt() {
		return (this.unit != null)? this.qty + this.unit : null;
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

	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public StuffExpireStatus getExpStatus() {
		return expStatus;
	}

	public void setExpStatus(StuffExpireStatus expStatus) {
		this.expStatus = expStatus;
	}
	
	@JsonIgnore
	public void setExpStatus(char expStatus) {
		this.expStatus = StuffExpireStatus.getByCode(expStatus);
	}
}
