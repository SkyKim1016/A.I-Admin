package com.onethefull.recipe.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.comm.util.CommonUtil;
import com.onethefull.recipe.type.RecommendType;

public class AiRecipeDetailVO {
	String userId;
	String recipeId;
	String recipeName;
	String recipeType;
	String cookingTime;
	String cookDifficulty;
	String imageUrl;
	List<CookingStep> cookingStep;
	private int countView;
	private int healthLevel;
	private int isRcmdbyHeath;
	private int isPopular;
	private int isTaste;
	private char isAIRecipe;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public String getRecipeType() {
		return recipeType;
	}
	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}
	public String getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}
	public String getDifficulty() {
		return cookDifficulty;
	}
	public void setDifficulty(String cookingDifficulty) {
		this.cookDifficulty = cookingDifficulty;
	}
	public List<CookingStep> getCookingStep() {
		return cookingStep;
	}
	public void setCookingStep(List<CookingStep> cookingStep) {
		this.cookingStep = cookingStep;
	}
	
	public AiRecipeDetailVO() {}
	
	public AiRecipeDetailVO(String userId, String recipeId, String recipeName, String recipeType, String imageUrl,
			String cookingTime, String cookingDifficulty, List<CookingStep> cookingStep) {
		super();
		this.userId = userId;
		this.recipeId = recipeId; 
		this.setRecipeName(recipeName);
		this.recipeType = recipeType;
		this.setImageUrl(imageUrl);
		this.cookingTime = cookingTime;
		this.cookDifficulty = cookingDifficulty;
		this.cookingStep = cookingStep;
	}
	public int getCookDifficulty() {
		return CommonUtil.getCookDifficulty(cookDifficulty); 
	}
	public void setCookDifficulty(String cookDifficulty) {
		this.cookDifficulty = cookDifficulty;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCountView() {
		return countView;
	}
	public void setCountView(int countView) {
		this.countView = countView;
	}
	@JsonIgnore
	public int getHealthLevel() {
		return healthLevel;
	}

	@JsonIgnore
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	@JsonIgnore
	public int getIsRcmdbyHeath() {
		return isRcmdbyHeath;
	}

	@JsonIgnore
	public void setIsRcmdbyHeath(int isRcmdbyHeath) {
		this.isRcmdbyHeath = isRcmdbyHeath;
	}

	@JsonIgnore
	public int getIsPopular() {
		return isPopular;
	}

	@JsonIgnore
	public void setIsPopular(int isPopular) {
		this.isPopular = isPopular;
	}

	@JsonIgnore
	public int getIsTaste() {
		return isTaste;
	}

	@JsonIgnore
	public void setIsTaste(int isTaste) {
		this.isTaste = isTaste;
	}

	@JsonIgnore
	public char getIsAIRecipe() {
		return isAIRecipe;
	}

	@JsonIgnore
	public void setIsAIRecipe(char isAIRecipe) {
		this.isAIRecipe = isAIRecipe;
	}

	public List<RecommendType> getRecommendType() {
		List<RecommendType> list = new ArrayList<RecommendType>();
		
		if(this.isAIRecipe == 'Y') list.add(RecommendType.CREATED);
		if(this.isRcmdbyHeath == 1 || this.healthLevel < 5) {
			list.add(RecommendType.HEALTH);
		}
		
		if(this.isPopular == 1 ) {
			list.add(RecommendType.POPULAR);			
		}
		
		if(this.isTaste == 1) {
			list.add(RecommendType.TASTE);			
		}
		
		
		
		return list;
	}

}
