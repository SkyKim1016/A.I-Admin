package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.comm.service.UserService;
import com.onethefull.recipe.comm.util.CommonUtil;
import com.onethefull.recipe.req.AuthTokenReq;

public class BaseController {
	
	@Resource(name = "userService")
	private UserService userService;

	public BaseController() {
		
	}
	
	public String getAuthToken(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getHeader("auth_token");
	}
	
	public User getUser(HttpServletRequest httpServletRequest) {

		String auth_token = httpServletRequest.getHeader("auth_token");
//		auth_token = CommonUtil.transSHA256(auth_token);  // auth_token 확인	
		if(auth_token != null) {
//			String oid = TokenUtil.decryptToken(auth_token);
			User findedUser = userService.getForSession(auth_token);
			if(findedUser != null) {
				findedUser.setAuthToken(auth_token);
//				AuthUtils.saveOrUpdateSession(httpServletRequest, findedUser);				
			}

			return findedUser;
		}
		
		return null;
	}	
	
}
