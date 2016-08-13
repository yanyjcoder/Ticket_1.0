package com.ticket.yanyj.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ticket.yanyj.util.StringUtil;

public class StringUtilTest {

	@Test
	public void testReplace() {
		String sql = "select * from table where i = ? and j = ?";
		List<Object> list = new ArrayList<>();
		list.add(1);
		list.add("����2");
		list.add("����2");
		System.out.println(StringUtil.replaceSql(sql, list));
	}
}
