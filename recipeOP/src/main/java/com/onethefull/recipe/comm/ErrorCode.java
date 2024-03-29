package com.onethefull.recipe.comm;

public class ErrorCode {
	/*
	 * DB Error Code Area : 800 ~ 899
	 * Network Error Code Area : 700 ~799
	 * File Error Code Area : 900 ~ 999
	 */
	
	public final static int SUCCESS = 0;
	public final static int FAIL = -1;
	public final static int INVALID_SIGN_ID = -2;
	public final static int INVALID_PASSWORD = -3;
	public final static int INVALID_PIN_NO = -4;
	public final static int IS_SECEDE = -5;
	public final static int INVALID_CONTENT = -11;
	public final static int NEED_PERMISSION = -12;
	public final static int NEED_LOGIN = -13;
	public final static int INVALID_PARAMETER = -14;
	public final static int NOTEXIST = -15;
	public final static int NOTEXISTORNEEDPERMISSION = -16;
	public final static int NOTEXIST_ORGINORTARGET = -17;
	public final static int ALREADY_EXIST = -18;
	public final static int INVALID_ACTION = -19;
	public final static int SUB_EXIST = -20;
	public final static int EXPIRE_DATE = -21;
	public final static int ILLEGAL_PROCESS = -30;
	public final static int INVALID_COUPONNUMBER = -31;
	public final static int OVER_UPPERLIMIT = -101;
	public final static int FRIENDSHIP_ALREADY_SETUP = -200;
	public final static int FRIENDSHIP_ALREADY_ON_REQUESTING = -201;
	public final static int FRIENDSHIP_ALREADY_SETUP_ON_CANCEL = -202;
	public final static int FRIENDSHIP_ALREADY_SETUP_ON_REJECT = -203;
	public final static int INVALID_PARAMETER_HOTLEVEL = -251;
	public final static int INVALID_PARAMETER_SWEETLEVEL = -252;
	public final static int NETWORK_ERROR = -770;
	public final static int DB_ERROR = -850;
	public final static int DB_TIME_OUT_ERROR = -860;
	public final static int FILE_NOT_FOUND_ERROR = -930;
	public final static int FILE_TYPE_ERROR = -931;
	public final static int FILE_WRITE_ERROR = -940;
	public final static int FILE_ENCODING_ERROR = -950;
	public final static int INVALID_KEY = -1024;
}