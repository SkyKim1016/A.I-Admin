package com.onethefull.recipe.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;
import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.mapper.ExternalAPIMapper;
import com.onethefull.recipe.req.ExternalWeatherReq;
import com.onethefull.recipe.vo.ExternalAPIWeatherVO;

@Service("externalAPIService")
public class ExternalAPIService {

	@Value("#{serverProperty['external.api.weather']}")
	private String externalAPIWeatherUrl;

	@Resource(name = "externalAPIMapper")
	private ExternalAPIMapper externalAPIMapper;
	
	public ResultWithData setWeatherInfo(HttpServletRequest request) {
	
		ResultWithData result2 = new ResultWithData();
	    try {
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        //GET 방식으로 parameter를 전달
	        HttpGet httpGet = new HttpGet(externalAPIWeatherUrl);
	        CloseableHttpResponse response = httpclient.execute(httpGet);
	        try {
	        	HttpEntity entity = response.getEntity();
	        	
	        	if (entity != null) {
	        		String retSrc = EntityUtils.toString(entity); 
	        		// parsing JSON
	        		
	        		ExternalWeatherReq req = new ExternalWeatherReq();
	        		
	        		JSONObject  result = new JSONObject(retSrc); //Convert String to JSON Object
	        		JSONObject coordObj = result.getJSONObject("coord");
	        		String longitude = coordObj.getString("lon"); 
	        		String latitude = coordObj.getString("lat");
	        		
	        		JSONObject mainObj = result.getJSONObject("main");
	        		String humidity = mainObj.getString("humidity"); 
	        		String temperature = mainObj.getString("temp");
	        		
	        		req.setLatitude(latitude);
	        		req.setLongitude(longitude);
	        		req.setHumidity(humidity);
	        		req.setTemperature(temperature);

	        		JSONArray weatherArr = result.getJSONArray("weather");
	        		if(weatherArr != null && weatherArr.length() > 0) {
	        			
	        			for(int i=0;i<weatherArr.length();i++) {
	        				JSONObject weatherObj = weatherArr.getJSONObject(i);
	        				String wcode = weatherObj.getString("id");
	        				
	        				req.addWeatherCode(wcode);
	        			}	        			
	        		}
	        		
	        		externalAPIMapper.registerWeather(req);
	        	}
	        } catch (Exception e) {
	        	 System.out.println(e.toString());
	            
	        } finally {
	            response.close();
	        } 
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
		return result2;
	}
	
	public byte[] getWeatherInfo(ExternalWeatherReq req, String wtype) throws UnsupportedEncodingException {

		req.setLongitude("127");  //***** 추후 지역 확대
		req.setLatitude("37.58");
		ExternalAPIWeatherVO info = externalAPIMapper.getWeatherInfo(req);
		
		String response = "";
		if("WEATHER".equals(wtype)) {
			response = info.getDescription();
		} else if("HUMIDITY".equals(wtype)) {
			response = info.getHumidity();
		} else if("TEMPERATURE".equals(wtype)) {
			response = info.getTemperature();
		}
		
		return response.getBytes("UTF-8");
	}
	
}
