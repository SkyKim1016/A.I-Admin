package com.onethefull.recipe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.req.ChattReq;
import com.onethefull.recipe.vo.ChattMessageVO;
import com.onethefull.recipe.vo.ChattVO;

@Repository("chattMapper")
public interface ChattMapper {
	
	public PageInfoVO getChattListPageInfo(ChattReq chattReq);
	public List<ChattVO> getChattList(ChattReq chattReq);
	public PageInfoVO getChattMessageListPageInfo(ChattReq chattReq);
	public List<ChattMessageVO> getChattMessageList(ChattReq chattReq);
	public int sendChattMessage(ChattReq chattReq);
	public int exitChatt(ChattReq chattReq);
	
}
