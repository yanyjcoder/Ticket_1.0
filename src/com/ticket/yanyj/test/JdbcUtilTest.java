package com.ticket.yanyj.test;

import java.sql.Connection;

import org.junit.Test;

import com.ticket.yanyj.constant.TicketConstant;
import com.ticket.yanyj.util.JdbcUtil;

@SuppressWarnings("unused")
public class JdbcUtilTest {

	@Test
	public void testCreateConnetion() {
		//Connection con = JdbcUtil.createConnetion(TicketConstant.STR_JDRIVER, TicketConstant.DB_STR, TicketConstant.DB_USER, TicketConstant.DB_PASSWORD);
		Connection con = null;
		JdbcUtil.closeConnetion(con);
	}
}
