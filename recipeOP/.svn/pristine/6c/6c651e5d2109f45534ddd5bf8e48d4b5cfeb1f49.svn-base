package com.onethefull.recipe.comm.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonUtil {
	static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	

	public CommonUtil() {
	}

	
	public static boolean isNumeric(String s) { 
	    java.util.regex.Pattern pattern = Pattern.compile("[+-]?\\d+"); 
	    return pattern.matcher(s).matches(); 
	} 	

	public static String getDatefromDateTimeString(String datetime) {
		if(datetime == null || datetime.length() <8) {
			return null;
		}
		
		return datetime.substring(0,4) + "-" + datetime.substring(4,6) + "-" + datetime.substring(6,8);
	}
	public static String getPriceFormat(String price) {
		return price.split(".")[0];
	}
	
    public static String getNullToSpace(String param) {
        return (param == null) ? "" : param.trim();
    }

	
	public static String transSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			SHA = null; 
		}
		return SHA;
	}



	public static Map<String, String> getUrlParameters(String query) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			for (String param : query.split("&")) {
				String pair[] = param.split("=");
				String key;
				key = URLDecoder.decode(pair[0], "UTF-8");

				String value = "";
				if (pair.length > 1) {
					value = URLDecoder.decode(pair[1], "UTF-8");
				}
				params.put(key, value);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
		return params;
	}

	public static String getPagingUrl(HttpServletRequest httpServletRequest) {
	    StringBuffer requestURL = new StringBuffer(httpServletRequest.getRequestURI());
	    String queryString = httpServletRequest.getQueryString();
	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
		    String strResult = null;
			int startIndexTmp = queryString.indexOf("&page=");
			if(startIndexTmp > 0) {
				strResult = queryString.substring(0, startIndexTmp);
		    	int endIndexTmp = queryString.indexOf("&", startIndexTmp);
		    	if(endIndexTmp > 0) {
		    		strResult.concat(queryString.substring(endIndexTmp));	
		    	}
			} else {
				strResult = queryString;
			}
	        return requestURL.append('?').append(strResult).toString();
	    }
	}
	
	public static String moneyFormatter(int num) {
		return String.format("%,d", num);
	}
	
	public static String moneyFormatter(String num) {
		return String.format("%,d", Integer.parseInt(num));
	}	
	
	public static String setStringToZero(String str, int size) {
		StringBuffer tempStr = new StringBuffer();
		tempStr.append(str);
		for(int i = 0; i < (size - str.length()); i++) {
			tempStr.append("0");
		}
		return tempStr.toString();
	}
	
	public static int getCookDifficulty(String d) {
		if( d == null || d.isEmpty()) return 3;
		int result = 3;
		try {
			result = Integer.valueOf(d);
		} catch (Exception e) {
			
		}
		return result;
	}	
	
//	public static String getCookDifficulty(String d) {
//		if( d == null || d.isEmpty()) return "중";
//		if("5".equals(d)) return "최상";
//		if("4".equals(d)) return "상";
//		if("3".equals(d)) return "중";
//		return "하";
//	}	
}
