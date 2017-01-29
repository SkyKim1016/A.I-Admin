package com.onethefull.recipe.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.comm.service.UserService;
import com.onethefull.recipe.req.ExternalWeatherReq;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.req.UserReq;
import com.onethefull.recipe.service.ExternalAPIService;
import com.onethefull.recipe.service.RecipeRcmdService;

@Controller
@RequestMapping("/rapi/ai")
public class MinaController extends BaseController {

	private final static Logger logger = LoggerFactory.getLogger(MinaController.class);
	
	@Resource(name = "recipeRcmdService")
	private RecipeRcmdService recipeRcmdService;
	
	@Resource(name = "externalAPIService")
	private ExternalAPIService externalAPIService;
	
	@Resource(name = "userService")
	private UserService userService;

	
	@RequestMapping(value = "recipe/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getRecipeList(HttpServletRequest request, @RequestParam(value="flUserID",required=false) String userId, @RequestParam(value="sceneNo",required=false) String sceneNo) {
		
		if( userId == null || userId.isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("flUserID is needed");
		}

		RcmdRecipeReq req = new RcmdRecipeReq();
		req.setUserId(userId);
		return recipeRcmdService.getRcmdRecipeforMina(req);
	}

	
	@RequestMapping(value = "weather/weather", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] getWeather(HttpServletRequest request) throws UnsupportedEncodingException {
		ExternalWeatherReq req = new ExternalWeatherReq();
		return externalAPIService.getWeatherInfo(req, "WEATHER");
	}

	@RequestMapping(value = "weather/humidity", method = RequestMethod.GET)
	@ResponseBody
	public byte[] geHumidity(HttpServletRequest request)  throws UnsupportedEncodingException {

		ExternalWeatherReq req = new ExternalWeatherReq();
		return externalAPIService.getWeatherInfo(req, "HUMIDITY");
	}

	@RequestMapping(value = "weather/temperature", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getTemperature(HttpServletRequest request)  throws UnsupportedEncodingException {

		ExternalWeatherReq req = new ExternalWeatherReq();
		return externalAPIService.getWeatherInfo(req, "TEMPERATURE");
	}

	@RequestMapping(value = "user/{userId}/name", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] getUserInfo(HttpServletRequest request, @PathVariable String userId, @RequestParam(value="providerID",required=false) String providerID)  throws UnsupportedEncodingException {

		UserReq req = new UserReq(userId);
		req.setProviderID(providerID);
		return userService.findUserbyId(req);
	}
	

}