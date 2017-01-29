package com.onethefull.recipe.res;

import com.onethefull.recipe.vo.RecipeIngrVOwithDday;

public class FridgeIngr {
	private String ingrCategoryId;
	private String ingrCategoryName;
	private RecipeIngrVOwithDday ingredient;
	
	public FridgeIngr() {}
	
	public FridgeIngr(String ingrCategoryId, String ingrCategoryName, RecipeIngrVOwithDday igredient) {
		this.setIngrCategoryId(ingrCategoryId);
		this.setIngrCategoryName(ingrCategoryName);
		this.setIngredient(igredient);
	}
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
	public RecipeIngrVOwithDday getIngredient() {
		return ingredient;
	}
	public void setIngredient(RecipeIngrVOwithDday ingredient) {
		this.ingredient = ingredient;
	}
}
