package com.ticket.yanyj.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ticket.yanyj.dao.ProfitDAO;
import com.ticket.yanyj.dao.TicketDAO;
import com.ticket.yanyj.dao.impl.ProfitDAOImpl;
import com.ticket.yanyj.dao.impl.TicketDAOImpl;
import com.ticket.yanyj.emty.Profit;
import com.ticket.yanyj.emty.Ticket;

public class ServiceTest {

	@Test
	public void testSave() throws ParseException {
		TicketDAO td = new TicketDAOImpl();
		Ticket ticket = new Ticket();
		ticket .setID("10062763255011");
		ticket.setClazz("123");
		ticket.setBetType("qwe");
		SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		ticket.setDate(sdf.parse(" 2008-7-1 19:20:00 "));
		ticket.setEndScore("1");
		ticket.setGmbl(0.01f);
		ticket.setJsbf("123");
		ticket.setOdds(0.01f);
		ticket.setStake(0.1f);
		ticket.setTeam("123");
		ticket.setType("123");
		
		try {
			td.save(ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() throws Exception {
		TicketDAO td = new TicketDAOImpl();
		System.err.println(td.get("12").getDate());
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		String date = sdf.format(td.get("12").getDate());
		System.out.println(date);
	}
	
	@Test
	public void testGetByCondition() throws Exception {
		TicketDAO td = new TicketDAOImpl();

		
		List<Ticket> lst =  td.getByCondition(null);
		System.out.println(JSON.toJSONString(lst));
		
	}
	
	@Test
	public void testUpadte() throws Exception {
		TicketDAO td = new TicketDAOImpl();
		Ticket t = td.get("12");
		t.setDate(new Date());
		System.out.println(td.update(t));
		System.out.println(td.get("12").getDate());
	}
	
	@Test
	public void testProfit() throws Exception {
		Profit profit = new Profit();
		profit.setDate("2016-08-22");
		profit.setBalance(0);
		profit.setBet_amount(1);
		profit.setBet_profit(0.5f);
		ProfitDAO pd = new ProfitDAOImpl();
		System.out.println(pd.get("2016-08-22").getBet_amount());
	}
}
