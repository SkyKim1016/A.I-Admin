package com.onethefull.recipe.comm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.PageInfoVO;
import com.onethefull.recipe.mapper.NotiMapper;
import com.onethefull.recipe.req.NotiReq;
import com.onethefull.recipe.type.NotiActionType;
import com.onethefull.recipe.vo.NotiVO;

@Service("notiService")
public class NotiService {
	
	@Resource(name = "notiMapper")
	private NotiMapper notiMapper;
	
	
	
	public ResultWithData getNotis(NotiReq req) {
		
		ResultWithData result = ResultWithData.succcessResult();
		PageInfoVO pageInfo = notiMapper.getNotiPageInfo(req);
		pageInfo.setCurrentPageNum(req.getPageNum());
		pageInfo.setPageSize(req.getPageSize());
		result.addData("pageInfo", pageInfo);
		List<NotiVO> list = notiMapper.getNotiList(req);
		return ResultWithData.succcessResult().addData("pageInfo", pageInfo).addData("list", list).addData("req", req);		
	}
	
	/*
	protected String setNotiTitle(NotiActionType actionType, NotiVO vo) {
		String title = "";
		
		if(vo == null || vo.getInfo() == null) return null;
		
		String infos[] = vo.getInfo().split("\\|");		
		
		switch(actionType) {
		case FRIENDSHIPREQUEST: 
			if(infos.length >= 2) {
				vo.setTitle(infos[1] + "님이 친구를 요청하였습니다.");
				vo.setTargetId(infos[0]);
			} else if (infos.length == 1) {
				vo.setTitle(infos[0]);
				vo.setTargetId(infos[0]);
			}
			break;
			
		case FRIENDSHIPACCEPT: 
			if(infos.length >= 2) {
				vo.setTitle(infos[1] + "님이 친구요청을 수락하였습니다.");
				vo.setTargetId(infos[0]);
			} else if (infos.length == 1) {
				vo.setTitle(infos[0]);
				vo.setTargetId(infos[0]);
			}
			break;
			
		case FRIENDSHIPREQUESTREJECTED: 
			if(infos.length >= 2) {
				vo.setTitle(infos[1] + "님이 친구요청을 거부하였습니다.");
				vo.setTargetId(infos[0]);
			} else if (infos.length == 1) {
				vo.setTitle(infos[0]);
				vo.setTargetId(infos[0]);
			}
			break;

		case COGNIZED: 
			vo.setTitle("식자재 인식 완료되었습니다.");
			vo.setTargetId(vo.getInfo());
			break;
			
		default : break;
		}
		
		return title;
	}
	*/

}
