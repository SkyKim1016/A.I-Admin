package com.onethefull.recipe.comm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.ContentMapper;
import com.onethefull.recipe.req.AnnounceReq;
import com.onethefull.recipe.vo.NotiVO;

@Service("contentService")
public class ContentService {
	
	@Resource(name = "contentMapper")
	private ContentMapper contentMapper;
	
	
	public ResultWithData getAnnounces(AnnounceReq req) {
		
		ResultWithData result = ResultWithData.succcessResult();
		PageInfoVO pageInfo = contentMapper.getAnnouncePageInfo(req);
		pageInfo.setCurrentPageNum(req.getPageNum());
		pageInfo.setPageSize(req.getPageSize());
		result.addData("pageInfo", pageInfo);
		List<NotiVO> list = contentMapper.getAnnounceList(req);

		return ResultWithData.succcessResult().addData("pageInfo", pageInfo).addData("list", list).addData("req", req);		
	}	

}
