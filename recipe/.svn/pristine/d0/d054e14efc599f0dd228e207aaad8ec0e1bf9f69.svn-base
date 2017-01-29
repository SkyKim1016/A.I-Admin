package com.onethefull.recipe.req;

import java.util.List;

import com.onethefull.recipe.vo.RecipeIngrVO;

public class RecipeSetReq extends RcmdRecipeReq {
	private List<RecipeIngrVO> recipeIngrList;
	
	public RecipeSetReq(){}
	
	public RecipeSetReq(String recipeId, String userId) {
		super();
		this.setRecipeId(recipeId);
		this.setUserId(userId);
	}

	public List<RecipeIngrVO> getRecipeIngrList() {
		return recipeIngrList;
	}

	public void setRecipeIngrList(List<RecipeIngrVO> recipeIngrList) {
		this.recipeIngrList = recipeIngrList;
	}
	
	public boolean isEmptyRecipeIngrList() {
		return recipeIngrList == null || recipeIngrList.isEmpty();
	}
}
