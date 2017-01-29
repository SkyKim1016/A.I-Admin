package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.req.RecipeSetReq;
import com.onethefull.recipe.service.MainService;

@Controller
@RequestMapping("/rapi/main")
public class MainController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name = "mainService")
	private MainService mainService;
	
	@RequestMapping(value = "recommend", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getRecommendRecipes(HttpServletRequest request) {
		User user = this.getUser(request);
		
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		
		RecipeSetReq req = new RecipeSetReq();
		req.setUserId(user.getId());
		req.setLanguageId(this.getLanguageId(request));

		return mainService.getRecommendRecipes(req);
	}

}