package com.onethefull.recipe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.req.EventReq;
import com.onethefull.recipe.vo.EventInfoVO;

@Repository("eventMapper")
public interface EventMapper {

	public int crudEventInfo(EventReq eventReq);
	public PageInfoVO getEventListPageInfo(EventReq eventReq);
	public EventInfoVO getEventInfo(EventReq eventReq);
	public List<EventInfoVO> getEventInfoList(EventReq eventReq);
	
}
