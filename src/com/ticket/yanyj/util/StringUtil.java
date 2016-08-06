package com.ticket.yanyj.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ�������
 * @author yanyj
 * @date 2016��7��30��
 */
public class StringUtil {

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
