package com.onethefull.recipe.comm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.mozilla.universalchardet.UniversalDetector;

public class FileEncodingChecker {
	private static UniversalDetector universalDetector = new UniversalDetector(null);

	public static boolean FileEncodingCheck(String file, String charset) throws IOException {
		FileInputStream fileStream = new FileInputStream(file);
		
		return FileEncodingCheck((InputStream) fileStream, charset);
	}
	
	public static boolean FileEncodingCheck(FileInputStream file, String charset) throws IOException {		
		return FileEncodingCheck((InputStream) file, charset);
	}
	
	public static boolean FileEncodingCheck(InputStream file, String charset) throws IOException {
		boolean result = false;
		byte[] buf = new byte[4096];

		int nread;
	    while ((nread = file.read(buf)) > 0 && !universalDetector.isDone()) {
	    	universalDetector.handleData(buf, 0, nread);
	    }

	    universalDetector.dataEnd();

	    String encoding = universalDetector.getDetectedCharset();
	    if (encoding != null && encoding.equalsIgnoreCase(charset)) {
	    	result = true;
	    }
	    universalDetector.reset();
	    return result;
	}
	
	public static void main(String args[]) throws  IOException, ClassNotFoundException, SQLException {
		try {
			FileEncodingChecker.FileEncodingCheck("/Users/kimsungjun/Documents/1.csv", FileEncodingType.UTF_8);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
