package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.req.RecipeStuffReq;
import com.onethefull.recipe.service.AdminService;

@Controller
@RequestMapping("/rapi/admin")
public class AdminController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@RequestMapping(value = "stuff", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData adminStuff(HttpServletRequest request, @RequestBody RecipeStuffReq req) {

		return adminService.adminStuff(req);
	}

}