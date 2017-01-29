package com.onethefull.recipe.comm.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class StrUtil {

	public StrUtil() { 
	}

	/**
	 * String�� null�� ��� ""�� �ٲپ� �ش�.
	 * 
	 * @param str
	 * @return
	 */
	public static String nvl(String str) {
		return nvl(str, "");
	}
	
	/**
	 * String�� null�� ��� ""�� �ٲپ� �ش�.
	 * 
	 * @param inStr
	 * @param outStr 
	 * @return
	 */
	public static String nvl(String inStr, String outStr) {
		if(inStr == null || "".equals(inStr)) {
			return outStr;
		}
		return inStr;
	}

	/**
	 * String�� ���ڷ� ��ȯ, null�� ��� ������ ���ڷ� �ٲپ� �ش�.
	 * 
	 * @param inStr
	 * @param outNum
	 * @return
	 */
	public static int nvl(String inStr, int outNum) {
		int num = outNum;
		if(inStr != null) {
			num = parseInt(inStr, outNum);
		}
		return num;
	}
	/**
	 * Object�� null�� ��� ""�� �ٲپ� �ش�.
	 * 
	 * @param obj
	 * @return
	 */
	public static String nvl(Object obj) {
		return nvl(obj, "");
	}
	
	/**
	 * Object�� null�� ��� ������ ���ڷ� �ٲپ� �ش�.
	 * 
	 * @param obj
	 * @param str
	 * @return
	 */
	public static String nvl(Object obj, String str) {
		if (obj == null || obj.toString().equals("null") || obj.toString().equals("")) {
			return str;
		}
		return obj.toString();
	}
	
	/**
	 * Object�� null�� ��� ������ ���ڷ� �ٲپ� �ش�.
	 * 
	 * @param obj
	 * @param str
	 * @return
	 */
	public static int nvl(Object obj, int num) {
		if(obj != null) {
			return parseInt(obj.toString(), num);
		}
		return num;
	}
	
	/**
	 * String�迭 Ÿ�� Object�� String�迭�� ��ȯ.
	 * 
	 * @param obj
	 * @param str
	 * @return
	 */
	public static String[] toArray(Object obj) {
		if(obj == null) {
			return new String[]{""};
		} else if(obj instanceof String[]) {
			return (String[]) obj;
		} else {
			return new String[]{nvl(obj)};
		}
	}

	/**
	 * ���ڿ�(str)�� ������ ����Ʈ(len)�� �ѱ涧 ����ǥ(tail)�� ���̰� �߶󳽴�.
	 * 
	 * @param str
	 * @param len
	 * @param tail
	 * @return
	 */
	public static String strCut(String str, int len, String tail) {
		char a;
		int i = 0;
		int realLen = 0;
		
		try {
			if(str == null) return "";
			int srcLen = str.getBytes().length;
			if (srcLen < len) return str;
			String tmpTail = tail;
			if (tail == null) tmpTail = "";
			int tailLen = tmpTail.getBytes().length;
			if (tailLen > len) return "";

			for (i = 0; i < len - tailLen && realLen < len - tailLen; i++) {
				a = str.charAt(i);
				if ((a & 0xFF00) == 0) realLen += 1;
				else realLen += 2;
			}
			while (str.substring(0, i).getBytes().length > len - tailLen) i--;
			return str.substring(0, i) + tmpTail;
		} catch (Exception e) {
			return str;
		}
	}

	/**
	 * ������(-)�� �����ڷ� ����ϴ� ��¥�� �߶� �迭�� �����Ѵ�.
	 * 
	 * @param str
	 * @return
	 */
	public static String[] dateSplit(String str) {
		if(str == null) {
			return new String[] {"", "", ""};
		}
		String arr[] = new String[3];
		String date[] = str.split("-");
		
		arr[0] = date.length <= 0 ? "" : date[0];
		arr[1] = date.length <= 1 ? "" : date[1];
		arr[2] = date.length <= 2 ? "" : date[2];
		
		return arr;
	}
	
	/**
	 * (@)�� �����ڷ� ����ϴ� �̸��� �߶� �迭�� �����Ѵ�.
	 * 
	 * @param str
	 * @return
	 */
	public static String[] emailSplit(String str) {
		if(str == null) {
			return new String[] {"", ""};
		}
		String arr[] = new String[2];
		String email[] = str.split("@");
		
		arr[0] = email.length <= 0 ? "" : email[0];
		arr[1] = email.length <= 1 ? "" : email[1];
		
		return arr;
	}
	
	/**
	 * ���ڸ� ���ڷ� ��ȯ�Ѵ�.(���� �� 0�� ����)
	 * 
	 * @param str
	 * @return
	 */
	public static int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * ���ڸ� ���ڷ� ��ȯ�Ѵ�.(��ȯ���� �� ������ ���ڷ� �ٲپ��ش�.)
	 * 
	 * @param str
	 * @param num
	 * @return
	 */
	public static int parseInt(String str, int num) {
		try {
			return Integer.parseInt(str);
		} catch(Exception e) {
			return num;
		}
	}

	/**
	 * ���ڹ迭�� ���ڹ迭�� ��ȯ�Ѵ�.
	 * 
	 * @param str
	 * @return
	 */
	public static int[] parseInt(String[] str) {
		if(str == null || str.length == 0) {
			return null;
		}
		int[] arrNum = new int[str.length]; 
		for(int i = 0; i < str.length; i++) {
			arrNum[i] = parseInt(str[i]);
		}
		return arrNum;
	}
	
	/**
	 * ������ �������� ���� ��¥�� �����Ѵ�.
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getToday(String pattern) {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(pattern);  
		return sdf.format(new java.util.Date());
	}
	
	/**
	 * ���������� ��¥(YYYYMMDD)�� ������(delimiter)�� �߰� �Ͽ� ��ȯ�Ѵ�.
	 *  
	 * @param date
	 * @param delimiter
	 * @return
	 */
	public static String getYMD(String date, String delimiter) {
		if(date != null && date.length() >= 8) {
			return date.substring(0, 4) + delimiter +  date.substring(4, 6) + delimiter + date.substring(6, 8);
		} else {
			return date;
		}
	}
	
	/**
	 * ������ ���ڿ� õ���� �޸��� ��� �����Ѵ�.
	 * 
	 * @param data
	 * @return
	 */
	public static String replaceComma(String data) {
		String formatNum = null;
		if(data != null) {
			int convert = parseInt(data);
			DecimalFormat df = new DecimalFormat("#,###");
			formatNum=(String)df.format(convert);
		}
		return formatNum;
	}
	
	/**
	 * XSS ������ ���� Ư������ ġȯ
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceXssStr(String str) {
		if(str != null) {
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			//str = str.replaceAll("#", "&#35;");
			//str = str.replaceAll("&", "&#38;");
			str = str.replaceAll("eval\\((.*)\\)", "");
			str = str.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
			//str = str.replaceAll("script", "");
			str = str.replaceAll("\">", "");
		}
		return str;
	}
	
	/**
	 * ���� ���輺�� �����ϴ� ���ڵ��� ���͸�
	 * 
	 * @param str
	 * @return
	 */
	public static String sqlFilter(String str) {
		if(str != null) {
			//str = str.replaceAll("'","''");
			//str = str.replaceAll("\"","\"\"");
			//str = str.replaceAll("\\","\\\\");
			//str = str.replaceAll(";", "");
			str = str.replaceAll("'","&#39;");
			str = str.replaceAll("\"","&quot;");
			str = str.replaceAll("--", "");
			//str = str.replaceAll(" ","");
		}
		return (str);
	}
	
	/**
	 * XSS ������ ���� Ư������ ġȯ, ���� ���輺�� �����ϴ� ���ڵ��� ���͸�
	 * 
	 * @param str
	 * @return
	 */
	public static String allFilter(String str){
		str = replaceXssStr(str); 
		str = sqlFilter(str);
		return str;
	}

	/**
	 * ���� Ư�� ���� ġȯ.
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceHTML(String str) {
		if(str == null) {
			return "";
		} else {
			return str.replaceAll("'", "&#39;").replaceAll("\"", "&quot;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		}
	}

	/**
	 * ġȯ�� ���� Ư�� ���� ����.
	 * 
	 * @param str
	 * @return
	 */
	public static String restoreHTML(String str) {
		if(str == null) {
			return "";
		} else {
			return str.replaceAll("&#39;", "'").replaceAll("&quot;", "\"").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		}
	}
}
