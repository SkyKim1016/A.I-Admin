package com.onethefull.recipe.comm.util;

import java.io.File;
import java.util.StringTokenizer;

public class FileUtil {
	
	//첨부파일 확장자 예약
	public static final String ALLOW_EXT_DOCUMENT = "doc|docx|xls|xlsx|ppt|pptx|hwp|zip|alz|txt|pdf|gul";	//문서 파일
	public static final String ALLOW_EXT_IMAGE = "gif|png|jpg|bmp|jpeg"; // 이미지 파일
	public static final String ALLOW_EXT_VIDEO = "wmv|avi|asf"; // 동영상 파일
	public static final String ALLOW_EXT_NORMAL = ALLOW_EXT_DOCUMENT + "|" + ALLOW_EXT_IMAGE + "|" + ALLOW_EXT_VIDEO;

	public FileUtil() {
	}

	/**
	 * 허용된 파일 확장자 검사
	 * 
	 * @param fileName
	 * @param fileExt
	 * @return
	 */
	public static boolean isAllowFileExt(String fileName, String fileExt) {
		boolean result = false;
		fileName = StrUtil.nvl(fileName).toLowerCase();
		fileExt = StrUtil.nvl(fileExt).toLowerCase();

		StringTokenizer st = new StringTokenizer(fileExt, "|");
		while(st.hasMoreTokens()) {
			if(fileName.endsWith("." + st.nextToken())) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * 파일명 변경
	 * @param oldPath  		현재 파일 시스템 경로
	 * @param oldFile  		현재 파일명
	 * @param newPath		변경될 파일 시스템경로
	 * @param newFile		변경될 파일명
	 * @return				변경된 파일명
	 */
	public static String fileRename(String oldPath, String oldFile, String newPath, String newFile){
		String str = "";
		try{
			String fileExt = oldFile.substring(oldFile.lastIndexOf(".") + 1);		// 확장자
			//String newFileName	= newFile + "." + fileExt;				// 변경될 파일
			String newFileName	= newFile;
			String newFilePath	= newPath + "/" + newFileName;			// 변경될 파일 전체경로 
			String tmpFile		= newFileName;
			int cnt = 1;
			while(new File(newFilePath).exists() && new File(newFilePath).isFile()) {		// 중복파일 체크
				int pos = newFileName.lastIndexOf(".");
				if(pos != -1) {
					tmpFile =  newFileName.substring(0, pos) + "(" + (cnt++) + ")" + newFileName.substring(pos);
				} else {
					tmpFile =  newFileName + "(" + (cnt++) + ")";
				}
				newFilePath = newPath + "/" + tmpFile;
			}
	
			File oldF = new File(oldPath + "/" + oldFile);		// 현재 파일
			File newF = new File(newFilePath);					// 변경될 파일
	
			oldF.renameTo(newF);
			str = newF.getName();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return str;
	}
}
