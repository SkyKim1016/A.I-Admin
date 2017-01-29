package com.onethefull.recipe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.comm.req.BaseReq;
import com.onethefull.recipe.req.FridgeIngrReq;
import com.onethefull.recipe.req.RecipeReq;
import com.onethefull.recipe.res.RecipeDetailNutrient;
import com.onethefull.recipe.res.RecipeDetailProcess;
import com.onethefull.recipe.vo.FridgeIngrVO;
import com.onethefull.recipe.vo.RecipeIngrVOwithDday;
import com.onethefull.recipe.vo.RecipeMasterVO;
import com.onethefull.recipe.vo.RecipeforFavoriteCheckVO;
import com.onethefull.recipe.vo.StuffVO;

@Repository("recipeMapper")
public interface RecipeMapper {

	public RecipeMasterVO getRecipeDetailMaster(RecipeReq req);
	public List<RecipeIngrVOwithDday> getRecipeStuffs(RecipeReq req);
	public List<RecipeDetailNutrient> getRecipeNutrients(RecipeReq req);
	public List<RecipeDetailProcess> getRecipeProcesses(RecipeReq req);
	public List<FridgeIngrVO> getFridgeIngr(FridgeIngrReq fridgeIngrReq);
	public List<RecipeforFavoriteCheckVO> getCheckFavoriteRecipeList(RecipeReq req);
	public int updateFridgeIngr(FridgeIngrReq fridgeIngrReq);
	public int increaseViewCount(RecipeReq req);
	public List<StuffVO> getIngrList(BaseReq baseReq);
	public List<StuffVO> getIngrListforCREATE(BaseReq baseReq);
	public int insertRecipeLike(RecipeReq req);
	public int deleteRecipeLike(RecipeReq req);

}
