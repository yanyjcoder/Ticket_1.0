package com.ticket.yanyj.test;

import java.sql.Connection;

import org.junit.Test;

import com.ticket.yanyj.constant.TicketConstant;
import com.ticket.yanyj.util.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testCreateConnetion() {
		Connection con = JdbcUtil.createConnetion(TicketConstant.STR_JDRIVER, TicketConstant.DB_STR, TicketConstant.DB_USER, TicketConstant.DB_PASSWORD);
		JdbcUtil.closeConnetion(con);
	}
}
