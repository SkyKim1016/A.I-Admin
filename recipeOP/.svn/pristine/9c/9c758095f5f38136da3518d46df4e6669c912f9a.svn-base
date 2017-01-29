package com.onethefull.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.AdminMapper;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.req.RecipeStuffReq;
import com.onethefull.recipe.req.UserMealReq;
import com.onethefull.recipe.res.RcmdRecipe;
import com.onethefull.recipe.type.AdminActionType;
import com.onethefull.recipe.vo.RcmdRecipeVO;
import com.onethefull.recipe.vo.RecipeStuffVO;
import com.onethefull.recipe.vo.StatisticMealofUserVO;
import com.onethefull.recipe.vo.StuffVO;

@Service("adminService")
public class AdminService {

	@Resource(name = "adminMapper")
	private AdminMapper adminMapper;
	
	public ResultWithData adminStuff(RecipeStuffReq req) {
		
		if(req.getActionType().equals(AdminActionType.CHANGE)) {
			req.setRecipeId(null);
			req.setStuffId(null);
			req.setQuantityInfo(req.getStuffTargetName()); // CHANGE에서는 quantityInfo에 대체재명을 넣는다.
		} else if(req.getActionType().equals(AdminActionType.DELETE)) {
			req.setRecipeId(null);
			req.setStuffId(null);
		}
		
		try {
			adminMapper.adminStuff(req);
		} catch (Exception e) {
			return ResultWithData.failuerResult();
		}
		
		return ResultWithData.succcessResult().addData("req", req);
	}

	public ResultWithData getRecipeList(RcmdRecipeReq req) {
		// TODO Auto-generated method stub
		
		PageInfoVO pageInfoVO = adminMapper.getRecipiesPageInfo(req);
		pageInfoVO.setCurrentPageNum(req.getPageNum());
		pageInfoVO.setPageSize(req.getPageSize());
		
		List<RcmdRecipeVO> list = adminMapper.getRecipies(req);
		List<RcmdRecipe> recipeList = new ArrayList<RcmdRecipe>();
		
		if(list != null && !list.isEmpty()) {
			for(RcmdRecipeVO recipe : list) {
				RcmdRecipe rr = new RcmdRecipe();			
				rr.setRecipeId(recipe.getRecipeId());
				rr.setRecipeName(recipe.getRecipeName());
				rr.setCategoryName(recipe.getCategoryName());
				rr.setRecipeImageOriginalUrl(recipe.getImageOriginalUrl());
				rr.setRecipeImageThumbUrl(recipe.getImageThumbUrl());
				rr.setRecipeImageUrl(recipe.getImageUrl());
				rr.setRecipeBaseOn(recipe.getBaseOn());		
				rr.setHealthLevel(recipe.getHealthLevel());
				rr.setIsRcmdbyHeath(recipe.getIsRcmdbyHeath());
				rr.setIsPopular(recipe.getIsPopular());
				rr.setIsTaste(recipe.getIsTaste());
				rr.setIsAIRecipe(recipe.getIsAIRecipe());
				rr.setCookingTime(String.valueOf(recipe.getCookingTime()) + "분");
				rr.setCookDifficulty(recipe.getCookDifficulty());
				
				recipeList.add(rr);
			}
		}
		
		return ResultWithData.succcessResult().addData("list", recipeList).addData("pageInfo", pageInfoVO);
		
	}
	
	
	public ResultWithData getIngrList(RecipeStuffReq req) {
		
		PageInfoVO pageInfoVO = adminMapper.getIngrListPageInfo(req);
		pageInfoVO.setCurrentPageNum(req.getPageNum());
		pageInfoVO.setPageSize(req.getPageSize());
		
		List<StuffVO> list = adminMapper.getIngrList(req);

		
		return ResultWithData.succcessResult().addData("list", list).addData("pageInfo", pageInfoVO);
	}
	
	public ResultWithData getIngrient(RecipeStuffReq req) {
		
		StuffVO stuff = adminMapper.getIngrient(req);

		return ResultWithData.succcessResult().addData("stuff", stuff);
	}

}
