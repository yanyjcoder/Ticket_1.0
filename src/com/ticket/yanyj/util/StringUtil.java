package com.ticket.yanyj.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class StringUtil {
	
	static final Logger log = Logger.getLogger("StringUtil");
	private static String errMethod = "";
	
	public static String replaceSql(String sql, List<Object> args) {
		errMethod = "[replaceSql] ";
		String[] strArr = sql.split("[?]");
		StringBuilder sb = new StringBuilder();
		if(strArr.length != args.size()) {
			log.error(errMethod + "占位符与参数不一致！");
			return null;
		}
		for(int i = 0; i < strArr.length; i++) {
			sb.append(strArr[i]);
			sb.append("'" + args.get(i) + "'");
		}
		
		return sb.toString();
	}
	
	/**
	 * 判断字符串不为空
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public static boolean isNotNull(String str) {
		if(str == null || "".equals(str)) {
			return false;
		}
		return true;
	} 
	
	/**
	 * 去除换行
	 * @author yanyj
	 * @date 2016年7月30日
	 */
	public static List<String> removeSpaceCharater(String str) {
		
		Pattern p = Pattern.compile("\t|\r|\n");
        Matcher m = p.matcher(str.trim());
        String dest = m.replaceAll("?");
		
        return removeNullString(dest.split("\\?"));
	}
	
	/**
	 * 去除字符数组中空字符串
	 * @author yanyj
	 * @date 2016年7月30日
	 */
	public static List<String> removeNullString(String[] strings) {
		List<String> strList = new ArrayList<String>();
		for (String str : strings) {
			if (str.trim().length() > 0) {
				strList.add(str);
			}
		}
		return strList;
	}
}
