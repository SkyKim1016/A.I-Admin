package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.req.ChattReq;
import com.onethefull.recipe.service.ChattService;
import com.onethefull.recipe.type.ChattActionType;

@Controller("/rapi/chatt")
public class ChattController extends BaseController {

	@Resource(name = "chattService")
	private ChattService chattService;
	
	/*
	 * 채팅방 목록 가져오기
	 * parameter : 
	 * 2016-6-28
	 * 김성준
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getChattList(HttpServletRequest request) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		ChattReq chattReq = new ChattReq(user.getId());
		chattReq.setLanguageId(this.getLanguageId(request));
		return chattService.getChattList(chattReq);
	}
	
	/*
	 * 채팅방 메세지 가져오기
	 * parameter : String chattId
	 * 2016-6-29
	 * 김성준
	 */
	@RequestMapping(value = "message/{chattId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getChattMessageList(HttpServletRequest request, @RequestParam(value = "chattId", required = true) String chattId) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		ChattReq chattReq = new ChattReq(user.getId());
		chattReq.setId(chattId);
		chattReq.setLanguageId(this.getLanguageId(request));
		return chattService.getChattMessageList(chattReq);
	}
	
	/*
	 * 채팅 메세지 보내기
	 * parameter : ChattReq
	 * 2016-6-28
	 * 김성준
	 */
	@RequestMapping(value = "message", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData sendChattMessage(HttpServletRequest request, @RequestBody ChattReq chattReq) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		chattReq.setUserId(user.getId());
		chattReq.setType(ChattActionType.SEND);
		chattReq.setLanguageId(this.getLanguageId(request));
		return chattService.sendChattMessage(chattReq);
	}
	
	/*
	 * 채팅방 나가기
	 * parameter : ChattReq
	 * 2016-6-28
	 * 김성준
	 */
	@RequestMapping(value = "exit", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultWithData exitChatt(HttpServletRequest request, @RequestBody ChattReq chattReq) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		chattReq.setLanguageId(this.getLanguageId(request));
		chattReq.setUserId(user.getId());
		chattReq.setType(ChattActionType.EXIT);
		return chattService.exitChatt(chattReq);
	}
	
}
