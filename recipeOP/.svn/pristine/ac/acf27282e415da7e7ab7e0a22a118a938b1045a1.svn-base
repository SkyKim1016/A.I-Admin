package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.service.RecipeRcmdService;

@Controller
@RequestMapping("/rapi/rcmd")
public class RecipeRecmdController extends BaseController {
	
	@Resource(name = "recipeRcmdService")
	private RecipeRcmdService recipeRcmdService;
	
	@RequestMapping(value = "/stuff/owning", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getUserStuffOwningList(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {
		return recipeRcmdService.getUserStuffOwningList(req);
	}
	
	@RequestMapping(value = "/pmi", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getPMIList(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {
		return recipeRcmdService.getRcmdStuffPMI(req);
	}
		
	@RequestMapping(value = "/recipe/find", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getRcmdRecipe(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {
		req.setIsIncludedStaticInfo(true);
		return recipeRcmdService.getRcmdRecipe(req);
	}
	
	@RequestMapping(value = "/recipe/list", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getRecipes(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {
		return recipeRcmdService.getRcmdRecipeList(req);
	}	
	
	@RequestMapping(value = "/recipe/list/sample", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getRecipes2(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {
		req.setIsIncludedStaticInfo(false);
		
		User user = this.getUser(request);
		
		if (user != null && user.getId() != null && !user.getId().isEmpty()) {
			req.setUserId(user.getId());
		}
		
		return recipeRcmdService.getRcmdRecipe(req);
	}		
}
