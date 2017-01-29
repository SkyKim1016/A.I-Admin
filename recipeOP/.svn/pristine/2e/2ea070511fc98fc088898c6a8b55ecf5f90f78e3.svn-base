package com.onethefull.recipe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.ChattMapper;
import com.onethefull.recipe.req.ChattReq;
import com.onethefull.recipe.vo.ChattMessageVO;
import com.onethefull.recipe.vo.ChattVO;

@Service("chattService")
public class ChattService {

	@Resource(name = "chattMapper")
	private ChattMapper chattMapper;
	
	public ResultWithData getChattList(final ChattReq chattReq) {
		ResultWithData result = ResultWithData.succcessResult();
		PageInfoVO pageInfoVO = chattMapper.getChattListPageInfo(chattReq);
		List<ChattVO> chattVOList = chattMapper.getChattList(chattReq);
		result.addData("list", chattVOList).addData("pageInfo", pageInfoVO);
		return result;
	}

	public ResultWithData getChattMessageList(final ChattReq chattReq) {
		ResultWithData result = ResultWithData.succcessResult();
		PageInfoVO pageInfoVO = chattMapper.getChattMessageListPageInfo(chattReq);
		List<ChattMessageVO> chattMessageVOList = chattMapper.getChattMessageList(chattReq);
		result.addData("list", chattMessageVOList).addData("pageInfo", pageInfoVO);
		return result;
	}
	
	public ResultWithData sendChattMessage(final ChattReq chattReq) {
		ResultWithData result = ResultWithData.succcessResult();
		if(StringUtils.isEmpty(chattReq.getReceiveUserId())) {
			result.setCode(ErrorCode.INVALID_PARAMETER);
		} else {
			chattMapper.sendChattMessage(chattReq);
			if(chattReq.getResultCode() != ErrorCode.SUCCESS) {
				result.setCode(chattReq.getResultCode());
			} else {
				ChattMessageVO chattMessageVO = new ChattMessageVO();
				chattMessageVO.setMessage(chattReq.getMessage());
				chattMessageVO.setCountRead(chattReq.getCountRead());
				result.addData("chattMessage", chattMessageVO);
			}
		}
		return result;
	}

	public ResultWithData exitChatt(final ChattReq chattReq) {
		ResultWithData result = ResultWithData.succcessResult();
		if(StringUtils.isEmpty(chattReq.getId())) {
			result.setCode(ErrorCode.INVALID_PARAMETER);
		} else {
			chattMapper.exitChatt(chattReq);
			if(chattReq.getResultCode() != ErrorCode.SUCCESS) {
				result.setCode(chattReq.getResultCode());
			}
		}
		return result;
	}

}
