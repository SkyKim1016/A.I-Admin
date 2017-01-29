package com.onethefull.recipe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.auth.User;
import com.onethefull.recipe.req.EventReq;
import com.onethefull.recipe.service.EventService;
import com.onethefull.recipe.type.CRUDActionType;

@Controller("eventController")
@RequestMapping("/rapi/event")
public class EventController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(EventController.class);

	@Resource(name = "eventService")
	private EventService eventService;
	
	/*
	 * 이벤트 상세
	 * parameter : String eventId
	 * 2016-6-30
	 * 김성준
	 */
	@RequestMapping(value = "{eventId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getEvent(HttpServletRequest request, @PathVariable String eventId) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		EventReq eventReq = new EventReq(eventId);
		eventReq.setLanguageId(this.getLanguageId(request));
		return eventService.getEvent(eventReq);
	}
	
	/*
	 * 이벤트 목록
	 * parameter :
	 * 2016-6-30
	 * 김성준
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getEventList(HttpServletRequest request) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		EventReq eventReq = new EventReq();
		eventReq.setLanguageId(this.getLanguageId(request));
		return eventService.getEventList(eventReq);
	}
	
	/*
	 * 이벤트 추가
	 * parameter : EventReq
	 * 2016-6-30
	 * 김성준
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData insertEventList(HttpServletRequest request, @RequestBody EventReq eventReq) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		eventReq.setLanguageId(this.getLanguageId(request));
		eventReq.setType(CRUDActionType.CREATE);
		return eventService.crudEventList(eventReq);
	}
	
	/*
	 * 이벤트 수정
	 * parameter : EventReq
	 * 2016-6-30
	 * 김성준
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResultWithData updateEventList(HttpServletRequest request, @RequestBody EventReq eventReq) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		eventReq.setLanguageId(this.getLanguageId(request));
		eventReq.setType(CRUDActionType.UPDATE);
		return eventService.crudEventList(eventReq);
	}
	
	/*
	 * 이벤트 삭제
	 * parameter : String eventId
	 * 2016-6-30
	 * 김성준
	 */
	@RequestMapping(value = "{eventId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultWithData deleteEventList(HttpServletRequest request, @PathVariable String eventId) {
		User user = this.getUser(request);
		if (user == null || user.getId() == null || user.getId().isEmpty()) {
			return ResultWithData.failuerResult().setCode(ErrorCode.NEED_LOGIN).setMessage("login is needed");
		}
		EventReq eventReq = new EventReq(eventId);
		eventReq.setLanguageId(this.getLanguageId(request));
		eventReq.setType(CRUDActionType.DELETE);
		return eventService.crudEventList(eventReq);
	}
}
