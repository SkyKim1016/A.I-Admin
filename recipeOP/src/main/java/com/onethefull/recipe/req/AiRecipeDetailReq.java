package com.onethefull.recipe.req;


public class AiRecipeDetailReq extends RecipeSetReq {
	private AIRecipeSurpriseLevel aiSurpriseLevel = AIRecipeSurpriseLevel.defaultAIRecipeSurpriseLevel();
	private String baseRecipeId;
	private String addRecipeId;
	private String newRecipeName;
	private String stuffName1;
	private String stuffName2;

	public AiRecipeDetailReq(){}
	public AiRecipeDetailReq(String recipeId, String userId) {
		super(recipeId, userId);
	}
	public AIRecipeSurpriseLevel getAiSurpriseLevel() {
		return aiSurpriseLevel;
	}
	public void setAiSurpriseLevel(AIRecipeSurpriseLevel aiSurpriseLevel) {
		this.aiSurpriseLevel = aiSurpriseLevel;
	}
	public String getBaseRecipeId() {
		return baseRecipeId;
	}
	public void setBaseRecipeId(String baseRecipeId) {
		this.baseRecipeId = baseRecipeId;
	}
	public String getAddRecipeId() {
		return addRecipeId;
	}
	public void setAddRecipeId(String addRecipeId) {
		this.addRecipeId = addRecipeId;
	}
	public String getNewRecipeName() {
		return newRecipeName;
	}
	public void setNewRecipeName(String newRecipeName) {
		this.newRecipeName = newRecipeName;
	}
	public String getStuffName1() {
		return stuffName1;
	}
	public void setStuffName1(String stuffName1) {
		this.stuffName1 = stuffName1;
	}
	public String getStuffName2() {
		return stuffName2;
	}
	public void setStuffName2(String stuffName2) {
		this.stuffName2 = stuffName2;
	}
}
