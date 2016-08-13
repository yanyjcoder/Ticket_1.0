package com.ticket.yanyj.util;

import java.util.List;

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
}
