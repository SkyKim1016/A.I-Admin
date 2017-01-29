package com.onethefull.recipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping(value = "/uploadrecipe", method = RequestMethod.GET)
	public String uploadRecipe(HttpServletRequest request) {
		return "uploadrecipe";
	}
	
	@RequestMapping(value = "/linkpage", method = RequestMethod.GET)
	public String linkPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "recipeId", required = true) String recipeId) {
		return "linkpage";
	}
}
