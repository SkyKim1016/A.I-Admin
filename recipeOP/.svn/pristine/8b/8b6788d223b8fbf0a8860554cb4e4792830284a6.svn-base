package com.onethefull.recipe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.req.AiRecipeDetailReq;
import com.onethefull.recipe.req.FridgeIngrReq;
import com.onethefull.recipe.req.RecipeIngrReq;
import com.onethefull.recipe.req.RecipeMasterReq;
import com.onethefull.recipe.req.RecipeSetReq;
import com.onethefull.recipe.vo.AiRecipeDetailVO;
import com.onethefull.recipe.vo.FridgeIngrVO;
import com.onethefull.recipe.vo.RcmdRecipeVO;
import com.onethefull.recipe.vo.RecipeIngrVO;
import com.onethefull.recipe.vo.RecipeSetVO;

@Repository("recipeSetMapper")
public interface RecipeSetMapper {

	public List<RecipeSetVO> getRecipeSet(RecipeSetReq req);
	public List<RecipeIngrVO> getRecipeIngr(RecipeIngrReq req);
	public List<FridgeIngrVO> getFridgeIngr(FridgeIngrReq req);
	public List<AiRecipeDetailVO> getAiRecipeDetail(AiRecipeDetailReq req);
	public int insertRecipeMaster(RecipeMasterReq req);
	public List<RcmdRecipeVO> getBaseRecipes(AiRecipeDetailReq req);
	public List<RcmdRecipeVO> getBaseRecipes2(AiRecipeDetailReq req);
	public List<RcmdRecipeVO> getAddRecipes(AiRecipeDetailReq req);

}
