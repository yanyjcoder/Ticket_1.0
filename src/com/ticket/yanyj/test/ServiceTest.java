package com.ticket.yanyj.test;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ticket.yanyj.dao.TicketDAO;
import com.ticket.yanyj.dao.impl.TicketDAOImpl;
import com.ticket.yanyj.emty.Ticket;

public class ServiceTest {

	@Test
	public void testSave() throws ParseException {
		TicketDAO td = new TicketDAOImpl();
		Ticket ticket = new Ticket();
		ticket .setID("12");
		ticket.setClazz("123");
		ticket.setBetType("qwe");
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
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
		Map<String, Object> map = new HashMap<>();
		map.put("ID", "126");
		map.put("odds", "0.01");

		
		List<Ticket> lst =  td.getByCondition(map);
		for(Ticket t : lst) {
			System.out.println(t.getID());
		}
		
	}
	
	@Test
	public void testUpadte() throws Exception {
		TicketDAO td = new TicketDAOImpl();
		Ticket t = td.get("12");
		t.setDate(new Date());
		System.out.println(td.update(t));
		System.out.println(td.get("12").getDate());
	}
	
}
