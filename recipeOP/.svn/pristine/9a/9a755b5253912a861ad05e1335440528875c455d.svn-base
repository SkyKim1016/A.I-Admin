package com.onethefull.recipe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.EventMapper;
import com.onethefull.recipe.req.EventReq;
import com.onethefull.recipe.req.RcmdRecipeReq;
import com.onethefull.recipe.vo.EventInfoVO;

@Service("eventService")
public class EventService {

	@Resource(name = "eventMapper")
	private EventMapper eventMapper;
	
	@Resource(name = "recipeRcmdService")
	private RecipeRcmdService recipeRcmdService;
	
	public ResultWithData getEvent(final EventReq eventReq) {
		ResultWithData result = ResultWithData.succcessResult();
		EventInfoVO eventInfoVO = eventMapper.getEventInfo(eventReq);
		if(eventInfoVO != null) {
			RcmdRecipeReq rcmdRecipeReq = new RcmdRecipeReq();
			rcmdRecipeReq.setEventId(eventReq.getEventId());
			switch (eventInfoVO.getType()) {
			case RECIPE:
				result = recipeRcmdService.getRcmdRecipe(rcmdRecipeReq);
				break;
			default:
				break;
			}
			if(result.getCode() == ErrorCode.SUCCESS) {
				result.addData("eventInfo", eventInfoVO);
			}			
		}
		return result;
	}

	public ResultWithData getEventList(EventReq eventReq) {
		ResultWithData result = ResultWithData.succcessResult();
		PageInfoVO pageInfoVO = eventMapper.getEventListPageInfo(eventReq);
		pageInfoVO.setCurrentPageNum(eventReq.getPageNum());
		pageInfoVO.setPageSize(eventReq.getPageSize());
		List<EventInfoVO> eventInfoVOList = eventMapper.getEventInfoList(eventReq);
		result.addData("pageInfo", pageInfoVO);
		result.addData("list", eventInfoVOList);
		return result;
	}

	public ResultWithData crudEventList(EventReq eventReq) {
		ResultWithData result = ResultWithData.succcessResult();
		eventMapper.crudEventInfo(eventReq);
		if(eventReq.getResultCode() != ErrorCode.SUCCESS) {
			result.setCode(eventReq.getResultCode());
			result.setMessage("DB Error");
		} else {
			result.addData("req", eventReq);
		}
		return result;
	}
	
}
