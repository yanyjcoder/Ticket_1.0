package com.ticket.yanyj.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;
import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;

public class TestAction extends BaseAction{
	private String ticketInfo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3620686942578689657L;

	@Override
	public String execute() throws Exception {
		List<Ticket> tickets = TicketUtil.convertStringToTicketMap(StringUtil.removeSpaceCharater(ticketInfo));
		TicketService ts = new TIcketServiceImpl();
		ts.saveAll(tickets);
		String result = JSON.toJSONString(tickets);
		this.renderText(result);
		System.out.println("JSON" + result);
		return "list";
	}

	
	public String getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
}
