package com.onethefull.recipe.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.req.RecipeReq;
import com.onethefull.recipe.req.RecipeSetReq;
import com.onethefull.recipe.res.RecipeDetail;
import com.onethefull.recipe.vo.RcmdRecipeVO;

@Service("mainService")
public class MainService {

	@Value("#{serverProperty['domain.url']}")
	private String domainUrl;
	
	@Resource(name = "recipeSetService")
	private RecipeSetService recipeSetService;

	@Resource(name = "recipeService")
	private RecipeService recipeService;

	
	public ResultWithData getRecommendRecipes(RecipeSetReq req) {
		
		RcmdRecipeVO rcmd1 = recipeSetService.getRecommendRecipebyPopular(req);
		RcmdRecipeVO rcmd2 = recipeSetService.getRecommendRecipebyTaste(req);
		RcmdRecipeVO rcmd3 = recipeSetService.getRecommendRecipebyHealth(req);
		
		RecipeDetail detail1 = recipeService.getRecipeDetail(new RecipeReq(rcmd1.getRecipeId()), "SIMPLE");
		RecipeDetail detail2 = recipeService.getRecipeDetail(new RecipeReq(rcmd2.getRecipeId()), "SIMPLE");
		RecipeDetail detail3 = recipeService.getRecipeDetail(new RecipeReq(rcmd3.getRecipeId()), "SIMPLE");
		
		return ResultWithData.succcessResult().addData("popular", detail1).addData("health", detail2).addData("taste", detail3);
	}
	
	

}
