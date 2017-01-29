package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.req.ExternalWeatherReq;
import com.onethefull.recipe.service.ExternalAPIService;

@Controller
@RequestMapping("/rapi/external")
public class ExternalAPIController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(ExternalAPIController.class);
	
	@Resource(name = "externalAPIService")
	private ExternalAPIService externalAPIService;
	
	@RequestMapping(value = "weather", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData setWeather(HttpServletRequest request) {
		return externalAPIService.setWeatherInfo(request);
	}

}