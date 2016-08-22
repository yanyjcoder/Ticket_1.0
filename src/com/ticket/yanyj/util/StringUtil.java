package com.ticket.yanyj.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.ticket.yanyj.emty.Ticket;

public class StringUtil {
	
	static final Logger log = Logger.getLogger("StringUtil");
	private static String errMethod = "";
	
	public static String replaceSql(String sql, List<Object> args, List<Object> order) {
		errMethod = "[replaceSql] ";
		int count = 0;
		for(int j = 0; j < sql.length(); j++) {
			if(sql.charAt(j) == '?') {
				count ++;
			}
		}
		String[] strArr = sql.split("[?]");
		StringBuilder sb = new StringBuilder();
		if(count != args.size()) {
			log.error(errMethod + "参数与占位符不一致！");
			return null;
		}
		for(int i = 0; i < count; i++) {
			sb.append(strArr[i]);
			sb.append("'" + args.get(i) + "'");
		}
		if(order  != null ) {
			sb.append(" order by " + order.get(0) + "," + order.get(1) + " desc");
		}
		return sb.toString();
	}
	
	/**
	 * 判断是否不为空
	 * @author yanyj
	 * @date 2016年8月17日
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		if(str == null || "".equals(str)) {
			return false;
		}
		return true;
	} 
	
	/**
	 * 去除空白符
	 * @author yanyj
	 * @date 2016年7月30日
	 */
	public static List<String> removeSpaceCharater(String str) {
		
		Pattern p = Pattern.compile("\t|\r|\n");
        Matcher m = p.matcher(str.trim());
        String dest = m.replaceAll("?");
		
        return removeNullString(dest.split(" "));
	}
	
	/**
	 * 按空格分隔字符串
	 * @author yanyj
	 * @date 2016年8月22日
	 * @描述
	 * @思路
	 * @param str
	 * @return
	 */
	public static String[] splitInfoBySpace(String str) {
		return str.split(" ");
	}
	
	
	/**
	 * 去除空字符串
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
	
	/**
	 * 转换成分页的JSon
	 * @author yanyj
	 * @date 2016年8月17日
	 * @return
	 */
	public static String convertToJsonQueryPara(List<Ticket> tickets, String pageStr, String rowsStr) {
		int totalRecord = tickets.size();
		int page = Integer.parseInt(pageStr);
		int rows = Integer.parseInt(rowsStr);
		int totalPage = totalRecord % rows == 0 ? totalRecord / rows : totalRecord / rows + 1;
		int index = (page - 1) * rows;// 开始记录数
		int pageSize = rows;

		String json = "{\"total\": \"" + totalPage + "\", \"page\": \"" + page + "\", \"records\": \"" 
					+ totalRecord + "\", \"rows\": [";
		for ( int i = index; i < pageSize + index && i < totalRecord; i++) {
				Ticket ticket = tickets.get(i);
				json +=	"{\"ID\": \"" + ticket.getID() 
					+ "\",\"id\": \"" + (i + 1) 
					+ "\",\"class\": \"" + ticket.getClazz() 
					+ "\",\"betType\": \"" + ticket.getBetType() 
					+ "\",\"endScore\": \"" + ticket.getEndScore() 
					+ "\",\"gmbl\": \"" + ticket.getGmbl() 
					+ "\",\"jsbf\": \"" + ticket.getJsbf().substring(1, ticket.getJsbf().length()-1)
					+ "\",\"odds\": \"" + ticket.getOdds()
					+ "\",\"stake\": \"" + ticket.getStake()
					+ "\",\"team\": \"" + ticket.getTeam()
					+ "\",\"type\": \"" + ticket.getType()
					+ "\",\"date\": \"" + ticket.getDate().toString()
					+ "\",\"status\": \"" + ticket.getStatus()
					+ "\",\"profit\": \"" + ticket.getProfit()+"\"}";
			if(i != pageSize + index - 1 && i != totalRecord - 1) {
				json += ",";
			}
		}
		json += "]}";
		return json;
	}
}
