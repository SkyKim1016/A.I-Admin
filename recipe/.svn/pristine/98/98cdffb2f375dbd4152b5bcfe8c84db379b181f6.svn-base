package com.onethefull.recipe.encrypt;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtil {

	@SuppressWarnings("finally")
	public static String StrToSHA512Base64Encrypt(String strValue, String charSet) {
		if(charSet == null || charSet.isEmpty()) {
			charSet = "UTF-8";
		}
		String encryptValue = "";
		try {
			encryptValue = Base64.encodeBase64String(DigestUtils.sha512(strValue.getBytes(charSet)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return encryptValue;			
		}
	}
	
}
