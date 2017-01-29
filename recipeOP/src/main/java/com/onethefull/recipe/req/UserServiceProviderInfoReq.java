package com.onethefull.recipe.req;

import com.onethefull.recipe.comm.req.BaseReq;
import com.onethefull.recipe.comm.social.UserSocialConnection;



public class UserServiceProviderInfoReq extends BaseReq {

	private UserReq userInfo;
	private UserSocialConnection socialConnectionInfo;
	private UserDeviceReq userDeviceInfo;
	private String resultCode;
	
	public UserServiceProviderInfoReq() {
		userInfo = new UserReq(); // userInfo는 항상 존재해야 함
	}
	

	public UserReq getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserReq userInfo) {
		this.userInfo = userInfo;
	}

	public UserSocialConnection getSocialConnectionInfo() {
		return socialConnectionInfo;
	}

	public void setSocialConnectionInfo(UserSocialConnection socialConnectionInfo) {
		this.socialConnectionInfo = socialConnectionInfo;
	}

	public UserDeviceReq getUserDeviceInfo() {
		return userDeviceInfo;
	}

	public void setUserDeviceInfo(UserDeviceReq userDeviceInfo) {
		this.userDeviceInfo = userDeviceInfo;
	}


	public String getResultCode() {
		return resultCode;
	}


	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	
	
}
