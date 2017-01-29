package com.onethefull.recipe.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.service.CognizeService;
import com.onethefull.recipe.req.CognizeReq;
import com.onethefull.recipe.req.ConditionCognizeReq;
import com.onethefull.recipe.type.CognizeActionType;

@Controller
@RequestMapping("/rapi/cognize")
public class CognizeController {

	@Resource(name = "cognizeService")
	private CognizeService cognizeService;
	
	/*
	 * 냉장고 식자재 인식 목록
	 * parameter : ConditionCognizeReq
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/condition/request", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData getCondtionCognizeRequestList(@RequestBody ConditionCognizeReq condtionCognizeReq) {
		return cognizeService.getCondtionCognizeRequestList(condtionCognizeReq);
	}

	/*
	 * 냉장고 식자재 인식 상세보기
	 * parameter : requestId(상세 Id), userId(관리자 Id)
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/condition/request/detail/{requestId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultWithData getCondtionCognizeRequestDetail(@PathVariable String requestId, @RequestParam(value = "userid", required = true) String userId) {
		CognizeReq cognizeReq = new CognizeReq();
		cognizeReq.setId(requestId);
		cognizeReq.setUserId(userId);
		return cognizeService.getCondtionCognizeRequestDetail(cognizeReq);
	}
	
	/*
	 * 냉장고 식자재 인식 완료
	 * parameter : requestId(상세 Id), ConditionCognizeReq
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/condition/request/detail/{requestId}", method = RequestMethod.POST)
	@ResponseBody
	public ResultWithData completeCondtionCognizeRequestDetail(@RequestBody ConditionCognizeReq conditionCognizeReq) {
		conditionCognizeReq.setActionType(CognizeActionType.COMPLETE);
		return cognizeService.updateCondtionCognizeRequestDetail(conditionCognizeReq);
	}
	
	/*
	 * 냉장고 식자재 인식 수정
	 * parameter : requestId(상세 Id), ConditionCognizeReq
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/condition/request/detail/{requestId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResultWithData updateCondtionCognizeRequestDetail(@RequestBody ConditionCognizeReq conditionCognizeReq) {
		if(!conditionCognizeReq.getActionType().equals(CognizeActionType.APPEND) 
				&& !conditionCognizeReq.getActionType().equals(CognizeActionType.OMIT)
				&& !conditionCognizeReq.getActionType().equals(CognizeActionType.TRANSFER)) {
			return ResultWithData.failuerResult().setCode(ErrorCode.INVALID_PARAMETER).setMessage("invaild parameter");
		}
		return cognizeService.updateCondtionCognizeRequestDetail(conditionCognizeReq);
	}
	
	/*
	 * 냉장고 식자재 인식 취소
	 * parameter : requestId(상세 Id), ConditionCognizeReq
	 * 2016-5-23
	 * 김성준
	 */
	@RequestMapping(value = "/condition/request/detail/{requestId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultWithData cancelCondtionCognizeRequestDetail(@RequestBody ConditionCognizeReq conditionCognizeReq) {
		conditionCognizeReq.setActionType(CognizeActionType.DELETE);
		return cognizeService.updateCondtionCognizeRequestDetail(conditionCognizeReq);
	}
}
