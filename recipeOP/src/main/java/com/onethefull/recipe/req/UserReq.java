package com.onethefull.recipe.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onethefull.recipe.comm.req.SearchReq;


public class UserReq extends SearchReq {
	
	private String id;
	private String ownerId;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String mobile;	
	private String gender;
	private String imageOriginalUrl;
	private String imageThumbUrl;
	private String status;
	private String healthId;
	private String jobId;
	private int activityLevel;
	private int ageLevel;
	private int selected;
	private boolean admin;
	private String providerID;
	private boolean isRegularMember;
	
	public UserReq() {
		super();
	}
	
	public UserReq(String id) {
		this.setId(id);
	}
	
	public UserReq(String loginId, String password) {
		super();
		this.setLoginId(loginId);
		this.setPassword(password);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getImageOriginalUrl() {
		return imageOriginalUrl;
	}

	public void setImageOriginalUrl(String imageOriginalUrl) {
		this.imageOriginalUrl = imageOriginalUrl;
	}

	public String getImageThumbUrl() {
		return imageThumbUrl;
	}

	public void setImageThumbUrl(String imageThumbUrl) {
		this.imageThumbUrl = imageThumbUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHealthId() {
		return healthId;
	}

	public void setHealthId(String healthId) {
		this.healthId = healthId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(int activityLevel) {
		this.activityLevel = activityLevel;
	}

	public int getAgeLevel() {
		return ageLevel;
	}

	public void setAgeLevel(int ageLevel) {
		this.ageLevel = ageLevel;
	}

	@JsonIgnore
	public int getSelected() {
		return selected;
	}

	@JsonIgnore
	public void setSelected(int selected) {
		this.selected = selected;
	}

	public boolean getIsSelected() {
		return selected == 1;
	}

	@JsonIgnore
	public boolean getAdmin() {
		return admin;
	}

	@JsonIgnore
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public boolean isIsRegularMember() {
		return isRegularMember;
	}

	public void setRegularMember(boolean isRegularMember) {
		this.isRegularMember = isRegularMember;
	}

}
