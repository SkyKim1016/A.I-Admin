package com.onethefull.recipe.comm.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.bson.types.ObjectId;

public class TokenUtil {

	public static String encryptToken(String token) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(token.getBytes()),"UTF-8");
//		return CipherUtil.encrypt(token);
	}
	
	public static String decryptToken(String token) throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64(token.getBytes()),"UTF-8");
//		return CipherUtil.decrypt(token);
	}
	
	public static boolean isObjectId(String token) {
		return ObjectId.isValid(token);
	}

}