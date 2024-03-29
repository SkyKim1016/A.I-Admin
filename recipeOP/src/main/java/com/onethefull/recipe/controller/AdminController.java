package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.comm.service.UserService;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.req.RecipeStuffReq;
import com.onethefull.recipe.req.UserReq;
import com.onethefull.recipe.service.AdminService;

@Controller
@RequestMapping("/rapi/admin")
public class AdminController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	
	@RequestMapping(value = "stuff", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData adminStuff(HttpServletRequest request, @RequestBody RecipeStuffReq req) {

		return adminService.adminStuff(req);
	}
	
	// 회원 목록
	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getUserList(HttpServletRequest request, @RequestBody UserReq req) {
		User user = this.getUser(request);
		
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		
		req.setOwnerId(user.getId());
		req.setLanguageId(this.getLanguageId(request));
		
		return userService.getUsers(req);
	}
	
	// 레시피 목록
	@RequestMapping(value = "recipe/list",method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getRecipeList(HttpServletRequest request, @RequestBody RcmdRecipeReq req) {

		req.setLanguageId(this.getLanguageId(request));
		
		return adminService.getRecipeList(req);
	}	
	
	// 식자재 목록
	@RequestMapping(value = "stuff/list",method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getIngrList(HttpServletRequest request, @RequestBody RecipeStuffReq req) {

		req.setLanguageId(this.getLanguageId(request));
		
		return adminService.getIngrList(req);
	}	

	// 식자재 상세
	@RequestMapping(value = "stuff/{stuffId}", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getIngrient(HttpServletRequest request, @PathVariable String stuffId, @RequestBody RecipeStuffReq req) {
		
		req.setStuffId(stuffId);
		return adminService.getIngrient(req);
	}	


}