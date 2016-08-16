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
			log.error(errMethod + "ռλ���������һ�£�");
			return null;
		}
		for(int i = 0; i < strArr.length; i++) {
			sb.append(strArr[i]);
			sb.append("'" + args.get(i) + "'");
		}
		
		return sb.toString();
	}
	
	/**
	 * �ж��ַ�����Ϊ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	public static boolean isNotNull(String str) {
		if(str == null || "".equals(str)) {
			return false;
		}
		return true;
	} 
	
	/**
	 * ȥ������
	 * @author yanyj
	 * @date 2016��7��30��
	 */
	public static List<String> removeSpaceCharater(String str) {
		
		Pattern p = Pattern.compile("\t|\r|\n");
        Matcher m = p.matcher(str.trim());
        String dest = m.replaceAll("?");
		
        return removeNullString(dest.split("\\?"));
	}
	
	/**
	 * ȥ���ַ������п��ַ���
	 * @author yanyj
	 * @date 2016��7��30��
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
