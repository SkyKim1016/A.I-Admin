package com.onethefull.recipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value = "/uploadrecipe", method = RequestMethod.GET)
	public String uploadRecipe(HttpServletRequest request) {
		return "uploadrecipe";
	}
	
}
