package com.ticket.yanyj.util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * ssc工具类
 * @author yanyj
 * @date 2016年10月7日
 */
public class CQSSUtil {

	/**
	 * 采集数据网址
	 */
	private static final String cpUrl = "http://trend.caipiao.163.com/cqssc/";
	
	/**
	 * 获取期号与号码，并保存
	 * @author yanyj
	 * @date 2016年10月8日
	 * @描述
	 * @思路
	 * @param lotteryDate
	 * @return
	 */
	public static Map<String, String> getLotteryNumber(String lotteryDate) {
		Map<String, String> cpData = new HashMap<>();
		Document document = JsoupHtmlConnetionUtil.getPageDocumentByUrl(cpUrl);
		Elements cpElements = JsoupHtmlConnetionUtil.getAllPageElementByDocument(document);
		cpElements.last();
		return cpData;
	}
	
	/**
	 * 保存ssc入数据库
	 * @author yanyj
	 * @date 2016年10月8日
	 * @描述
	 * @思路
	 * @param data_period
	 * @param data_Aware
	 * @return
	 */
	public static boolean saveAware(String data_period, String data_Aware) {
		
		return true;
	}
}
