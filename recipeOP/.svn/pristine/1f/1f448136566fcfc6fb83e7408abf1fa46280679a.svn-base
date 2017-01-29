package com.onethefull.recipe.res;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.NumberUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.type.RecommendType;

public class RecipeDetail {
	private final static int INT_SCALE = 0;
	private final static BigDecimal BD_DIVISION_NUMBER = new BigDecimal("2");
	private String recipeId;
	private String recipeName;
	private String categoryName;
	private String categoryId;
	private String writer;
	private String writerImageUrl;
	private int perPerson;
	private String cookingTime;
	private int calorie;
	private String imageUrl;
	private String referedUrl;
	private String storageInfo;
	private String memo;
	private int cookDifficulty;
	private int countView;
	private int healthLevel;
	private int isRcmdbyHeath;
	private int isPopular;
	private int isTaste;
	private char isAIRecipe;
	private char isLike = 'N';
	private String rateHealth = "76.22";
	private String rateTaste = "98.00";
	private String ratePopular = "0";
	
	private List<FridgeIngr> stuffs;
	private List<RecipeDetailProcess> processes;
	private List<RecipeDetailNutrient> nutrients;

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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getWriter() {
		if(this.getIsAIRecipe() != 'Y') {
			return null;
		}
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriterImageUrl() {
		return writerImageUrl;
	}

	public void setWriterImageUrl(String writerImageUrl) {
		this.writerImageUrl = writerImageUrl;
	}

	public int getPerPerson() {
		return perPerson;
	}

	public void setPerPerson(int perPerson) {
		this.perPerson = perPerson;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public String getReferedUrl() {
		return referedUrl;
	}

	public void setReferedUrl(String referedUrl) {
		this.referedUrl = referedUrl;
	}

	public String getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(String storageInfo) {
		this.storageInfo = storageInfo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getCookDifficulty() {
		return this.cookDifficulty;
//		return CommonUtil.getCookDifficulty(String.valueOf(cookDifficulty)); 
	}

	public void setCookDifficulty(int cookDifficulty) {
		this.cookDifficulty = cookDifficulty;
	}

	public int getCountView() {
		return countView;
	}

	public void setCountView(int countView) {
		this.countView = countView;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<FridgeIngr> getStuffs() {
		return stuffs;
	}

	public void setStuffs(List<FridgeIngr> stuffs) {
		this.stuffs = stuffs;
	}

	public List<RecipeDetailProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(List<RecipeDetailProcess> processes) {
		this.processes = processes;
	}

	public List<RecipeDetailNutrient> getNutrients() {
		return nutrients;
	}

	public void setNutrients(List<RecipeDetailNutrient> nutrients) {
		this.nutrients = nutrients;
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

	public char getIsLike() {
		return isLike;
	}

	public void setIsLike(char isLike) {
		this.isLike = isLike;
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

	public String getRateTotal() {
		BigDecimal rateTotal = BigDecimal.ZERO;
		rateTotal = rateTotal.add(NumberUtils.parseNumber(this.rateHealth, BigDecimal.class));
		rateTotal = rateTotal.add(NumberUtils.parseNumber(this.rateTaste, BigDecimal.class));
		return rateTotal.divide(BD_DIVISION_NUMBER, INT_SCALE, BigDecimal.ROUND_UP).toString();
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
