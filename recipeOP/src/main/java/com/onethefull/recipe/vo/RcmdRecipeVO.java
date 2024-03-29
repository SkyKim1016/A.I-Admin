package com.onethefull.recipe.vo;

import java.math.BigDecimal;

public class RcmdRecipeVO {
	private String recipeId;
	private String recipeName;
	private String categoryName;
	private int cookingTime;
	private int cookDifficulty;
	private String imageUrl;
	private String imageOriginalUrl;
	private String imageThumbUrl;
	private String baseOn;
	private BigDecimal nutrientQty1;
	private BigDecimal nutrientQty2;
	private String nutrientMeasure1;
	private String nutrientMeasure2;
	private int healthLevel;
	private int isRcmdbyHeath;
	private int isPopular;
	private int isTaste;
	private char isAIRecipe;
	private String rateHealth = "0";
	private String rateTaste = "0";
	private String ratePopular = "0";

	public RcmdRecipeVO() {}


	public String getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}


	public String getRecipeName() {
		return recipeName;
	}


	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public int getCookDifficulty() {
		return cookDifficulty;
	}


	public void setCookDifficulty(int cookDifficulty) {
		this.cookDifficulty = cookDifficulty;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getImageOriginalUrl() {
		return imageOriginalUrl;
	}


	public void setImageOriginalUrl(String imageOriginalUrl) {
		this.imageOriginalUrl = imageOriginalUrl;
	}


	public String getImageThumbUrl() {
		return imageThumbUrl;
	}


	public void setImageThumbUrl(String imageThumbUrl) {
		this.imageThumbUrl = imageThumbUrl;
	}


	public String getBaseOn() {
		return baseOn;
	}


	public void setBaseOn(String baseOn) {
		this.baseOn = baseOn;
	}


	public BigDecimal getNutrientQty1() {
		return nutrientQty1;
	}


	public void setNutrientQty1(BigDecimal nutrientQty1) {
		this.nutrientQty1 = nutrientQty1;
	}


	public BigDecimal getNutrientQty2() {
		return nutrientQty2;
	}


	public void setNutrientQty2(BigDecimal nutrientQty2) {
		this.nutrientQty2 = nutrientQty2;
	}


	public String getNutrientMeasure1() {
		return nutrientMeasure1;
	}


	public void setNutrientMeasure1(String nutrientMeasure1) {
		this.nutrientMeasure1 = nutrientMeasure1;
	}


	public String getNutrientMeasure2() {
		return nutrientMeasure2;
	}


	public void setNutrientMeasure2(String nutrientMeasure2) {
		this.nutrientMeasure2 = nutrientMeasure2;
	}


	public int getHealthLevel() {
		return healthLevel;
	}


	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}


	public int getIsRcmdbyHeath() {
		return isRcmdbyHeath;
	}


	public void setIsRcmdbyHeath(int isRcmdbyHeath) {
		this.isRcmdbyHeath = isRcmdbyHeath;
	}


	public int getIsPopular() {
		return isPopular;
	}


	public void setIsPopular(int isPopular) {
		this.isPopular = isPopular;
	}


	public int getIsTaste() {
		return isTaste;
	}


	public void setIsTaste(int isTaste) {
		this.isTaste = isTaste;
	}


	public char getIsAIRecipe() {
		return isAIRecipe;
	}

	public void setIsAIRecipe(char isAIRecipe) {
		this.isAIRecipe = isAIRecipe;
	}


	public String getRateHealth() {
		return rateHealth;
	}


	public void setRateHealth(String rateHealth) {
		this.rateHealth = rateHealth;
	}


	public String getRateTaste() {
		return rateTaste;
	}


	public void setRateTaste(String rateTaste) {
		this.rateTaste = rateTaste;
	}


	public String getRatePopular() {
		return ratePopular;
	}


	public void setRatePopular(String ratePopular) {
		this.ratePopular = ratePopular;
	}

}
