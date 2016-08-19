package com.ticket.yanyj.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;
import com.ticket.yanyj.util.StringUtil;

public class StringUtilTest {

	@Test
	public void testReplace() {
		String sql = "select * from table where i = ? and j = ?";
		List<Object> list = new ArrayList<>();
		list.add(1);
		list.add("参数2");
		list.add("参数2");
		System.out.println(StringUtil.replaceSql(sql, list, null));
	}
	
	@Test
	public void testIsNotNull() throws Exception {
		TicketService ts = new TIcketServiceImpl();
		//ts.saveAll(tickets);
		String result = JSON.toJSONString(ts.getByCondition(null));
		System.out.println(result);
		
		String json = StringUtil.convertToJsonQueryPara(ts.getByCondition(null), "1", "10");
		System.out.println(json);
	}
}
