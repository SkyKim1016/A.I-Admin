package com.onethefull.recipe.comm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.req.PushReq;
import com.onethefull.recipe.comm.restful.RestFulAPI;
import com.onethefull.recipe.comm.restful.RestFulType;

@Service("pushSender")
public class PushSender {
	
	@Value("#{serverProperty['push.url']}")
	private String pushUrl;
	
	public ResultWithData sendPush(final PushReq pushReq) {
		ResultWithData result = ResultWithData.succcessResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pushInfos", pushReq);
		RestFulAPI.restFulApi(RestFulType.POST, pushUrl, map, null);
		return result;
	}
	
}
