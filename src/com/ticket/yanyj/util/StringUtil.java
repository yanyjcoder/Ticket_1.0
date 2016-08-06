package com.ticket.yanyj.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理
 * @author yanyj
 * @date 2016年7月30日
 */
public class StringUtil {

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
