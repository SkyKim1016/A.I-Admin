package com.onethefull.recipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ResultWithData;

@Controller
@RequestMapping("/rapi")
public class HealthCheckController {
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData uploadRecipe(HttpServletRequest request) {
		return ResultWithData.succcessResult();
	}
	
}
