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
import com.onethefull.recipe.comm.service.ContentService;
import com.onethefull.recipe.req.AnnounceReq;

@Controller
@RequestMapping("/rapi/content")
public class ContentController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@Resource(name = "contentService")
	private ContentService contentService;
	
		
	// 알림 목록
	@RequestMapping(value = "announce/list",method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getNotiList(HttpServletRequest request, @RequestBody AnnounceReq req) {
		
		return contentService.getAnnounces(req);
	}	
}