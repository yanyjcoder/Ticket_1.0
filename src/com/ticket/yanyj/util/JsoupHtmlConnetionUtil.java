package com.ticket.yanyj.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * 网络爬虫工具类
 * @author yanyj
 * @date 2016年10月8日
 */
public class JsoupHtmlConnetionUtil {
	private static Logger logger = Logger.getLogger("JsoupHtmlConnetionUtil.class");
	
	/**
	 * 通过url获取页面
	 * @author yanyj
	 * @date 2016年10月8日
	 * @描述
	 * @思路
	 * @param urlPath
	 * @return
	 */
	public static Document getPageDocumentByUrl(String urlPath) {
		Document document = null;
		try {
			document = Jsoup.connect(urlPath).get();
			logger.info("爬虫获取document成功！");
		} catch (IOException e) {
			logger.info("爬虫获取document失败！" + e.getMessage());
			
		}
		return document;
	}
	
	/**
	 * 获取指定的elements
	 * @author yanyj
	 * @date 2016年10月8日
	 * @描述
	 * @思路
	 * @param document
	 * @return
	 */
	public static Elements getAllPageElementByDocument(Document document){
		Elements elements = null;
		//System.out.println(document.toString());
		elements = document.getElementsByAttribute("data-period");
//		for(Element cpData : elements) {
//			System.out.println("期号：" + cpData.attr("data-period") + "   开奖号码：" + cpData.attr("data-award").trim());			
//		}
		return elements;
	}
	
	@Test
	public void testElement() {
		getAllPageElementByDocument(getPageDocumentByUrl("http://trend.caipiao.163.com/cqssc/"));
	}
}
