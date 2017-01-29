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

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.comm.service.NotiService;
import com.onethefull.recipe.req.NotiReq;

@Controller
@RequestMapping("/rapi/noti")
public class NotiController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(NotiController.class);
	
	@Resource(name = "notiService")
	private NotiService notiService;
	
		
	// 알림 목록
	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getNotiList(HttpServletRequest request, @RequestBody NotiReq req) {
		User user = this.getUser(request);
		
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		
		req.setUserId(user.getId());
		req.setLanguageId(this.getLanguageId(request));
		
		return notiService.getNotis(req);
	}	
}