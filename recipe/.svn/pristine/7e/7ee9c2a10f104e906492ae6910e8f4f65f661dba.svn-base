package com.onethefull.recipe.req;

import java.util.ArrayList;

public class ExternalWeatherReq {
	private String longitude; 
	private String latitude;
	private String humidity;
	private String temperature;
	private ArrayList<String> weatherCode;
	private int resultCode;
	
	public ExternalWeatherReq(){}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public ArrayList<String> getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(ArrayList<String> weatherCode) {
		this.weatherCode = weatherCode;
	}
	
	public void addWeatherCode(String code) {
		if(this.weatherCode == null ) {
			this.weatherCode = new ArrayList<String>();
		}
		
		this.weatherCode.add(code);
	}
	
	public String getWeatherInfo() {
		if(this.weatherCode == null || this.weatherCode.isEmpty()) {
			return null;
		}
		
		String result = "";
		for(String code : this.weatherCode) {
			result = ((!result.isEmpty())? ";" : "") + code; 
		}
		
		return result;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}


	
}
