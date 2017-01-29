package com.onethefull.recipe.req;

public class RecipeNutrientReq {

	private String recipeId;
	private String nutrientName;
	private String quantityInfo;
	
	public RecipeNutrientReq(){}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getNutrientName() {
		return nutrientName;
	}

	public void setNutrientName(String nutrientName) {
		this.nutrientName = nutrientName;
	}

	public String getQuantityInfo() {
		return quantityInfo;
	}

	public void setQuantityInfo(String quantityInfo) {
		this.quantityInfo = quantityInfo;
	}


}
