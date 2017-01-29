package com.onethefull.recipe.comm.restful;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

public class RestFulAPI {
	private static Gson gson = new Gson();
	@SuppressWarnings("finally")
	public static String restFulApi(RestFulType restFulType, String url, Object data, String jsonData) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpRequestBase request = null;
		switch (restFulType) {
			case GET:
				request = new HttpGet(url);
				break;
			case PUT:
				request = new HttpPut(url);
				break;
			case POST:
				request = new HttpPost(url);
				break;
			case DELETE:
				request = new HttpDelete(url);
				break;
		default:
			break;
		}
//		request.setHeader("Content-Type", "application/json; charset=UTF-8");
//		request.setHeader("Accept", "application/json");
		request.setHeader("Content-Type", "application/json; charset=UTF-8");
		request.setHeader("Accept", "application/json");
		if(data != null) {
			jsonData = gson.toJson(data);
		}
		//jsonData = "{'smode' : 'search', 'mode' : 'list', 'sh[year]' : '2015', 'sh[month]' : '12', 'sh[day]' : '31', 'sh[year2]' : '2015', 'sh[month2]' : '12', 'sh[day2]' : '31'}";
		StringEntity input;
		HttpResponse response = null;
		String responseBody = null;
		try {
			//UTF-8 처리 꼭 필요
			input = new StringEntity(jsonData, "UTF-8");
			((HttpEntityEnclosingRequestBase) request).setEntity(input);
			response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
			    StringBuffer buffer = new StringBuffer();
			    byte[] b = new byte[4096];
			    int i;
			    while( (i = instream.read(b)) != -1) {
			    	buffer.append(new String(b, 0, i));
			    }
			    responseBody = buffer.toString();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return responseBody;
		}
	}
}
