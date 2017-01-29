package com.onethefull.recipe.comm.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.onethefull.recipe.comm.auth.DeviceType;
import com.onethefull.recipe.comm.req.PushReq;
import com.onethefull.recipe.comm.req.PushSendType;
import com.onethefull.recipe.comm.vo.DeviceVO;

public class PushServiceTest {
	String[] paths = { "classpath:config/mail-config.xml" };
	ApplicationContext context;
	PushService pushService;
	PushServiceTest() {
		context = new FileSystemXmlApplicationContext(paths);
		pushService = (PushService) context.getBean("pushService");
	}
	
	public void testSendPush() {
		DeviceVO deviceVO = new DeviceVO();
		deviceVO.setRegid("APA91bHEkVAEdo9PVLIYNirQ_vUN0JfCQo0LT0cTkFrritfDQaAImWLFHc9pA4pwu-GpYJkmRrCwwzTRdLMxoJ9s8wGRpz6C_9-MP4zLI2M4C8Peb98WAwt6EXrLgUMeC1t74_-K2jHX");
		deviceVO.setDeviceType(DeviceType.ANDROID);
		PushReq pushReq = new PushReq();
		pushReq.addDevice(deviceVO);
		pushReq.setTitle("식자재 인식이 완료되었습니다");
		pushReq.setMessage("식자재 인식이 완료되었습니다");
		pushService.sendPush(PushSendType.COGNIZE, pushReq);
	}

	public static void main(String[] args) {
		PushServiceTest test = new PushServiceTest();
		test.testSendPush();
	}
}
