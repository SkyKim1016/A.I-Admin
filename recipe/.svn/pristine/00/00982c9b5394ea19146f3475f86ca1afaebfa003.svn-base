package com.onethefull.recipe.comm.service;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ErrorCode;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.req.PushReq;
import com.onethefull.recipe.comm.req.PushSendType;
import com.onethefull.recipe.comm.vo.DeviceVO;
import com.onethefull.recipe.mapper.UserAuthMapper;
import com.onethefull.recipe.req.UserDeviceReq;

@Service("pushService")
public class PushService {
	private final static Logger logger = LoggerFactory.getLogger(PushService.class);
	
	@Resource(name = "pushSender")
	private PushSender pushSender;
	
	@Resource(name = "userAuthMapper")
	private UserAuthMapper userAuthMapper;
	
	@Async
	public Future<ResultWithData> sendPush(final PushSendType pushSendType, PushReq pushReq) {
		ResultWithData resultWithData = ResultWithData.succcessResult();
		//TODO 푸쉬 연동 부분 개선
		if(pushReq.getUserIdList() == null || pushReq.getUserIdList().isEmpty()) {
			resultWithData.setCode(ErrorCode.INVALID_PARAMETER);
		} else {
			for(String userId : pushReq.getUserIdList()) {
				UserDeviceReq userDeviceReq = new UserDeviceReq();
				userDeviceReq.setUserId(userId);
				DeviceVO deviceVO = userAuthMapper.getUserDeviceInfo(userDeviceReq);
				pushReq.addDevice(deviceVO);	
			}
			switch (pushSendType) {
				case FRIENDREQUEST:
					pushReq.setTitle("친구 요청이 있습니다");
					pushReq.setMessage("친구 요청이 있습니다");
					break;
				case FRIENDREQUESTACCEPT:
					pushReq.setTitle("친구 요청이 수락되었습니다");
					pushReq.setMessage("친구 요청이 수락되었습니다");
					break;
				case FRIENDREQUESTREJECT:
					pushReq.setTitle("친구 요청이 거부되었습니다");
					pushReq.setMessage("친구 요청이 거부되었습니다");
					break;
				case COGNIZE:
				default:
					pushReq.setTitle("식자재 인식이 완료되었습니다");
					pushReq.setMessage("식자재 인식이 완료되었습니다");
					break;
			}
			resultWithData = pushSender.sendPush(pushReq);
		}
		return new AsyncResult<ResultWithData>(resultWithData);
	}
	
}
