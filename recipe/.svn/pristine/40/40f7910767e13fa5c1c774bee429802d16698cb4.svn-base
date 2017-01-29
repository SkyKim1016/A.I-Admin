package com.onethefull.recipe.mapper;

import org.springframework.stereotype.Repository;

import com.onethefull.recipe.req.ExternalWeatherReq;
import com.onethefull.recipe.vo.ExternalAPIWeatherVO;

@Repository("externalAPIMapper")
public interface ExternalAPIMapper {

	public int registerWeather(ExternalWeatherReq req);
	ExternalAPIWeatherVO getWeatherInfo(ExternalWeatherReq req);
	
}
