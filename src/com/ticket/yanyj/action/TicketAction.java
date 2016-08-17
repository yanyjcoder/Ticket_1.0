package com.ticket.yanyj.action;

import java.util.List;

import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;
import com.ticket.yanyj.util.StringUtil;

public class TicketAction extends BaseAction{
	private String ticketInfo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3620686942578689657L;

	public String list() throws Exception {
		TicketService ts = new TIcketServiceImpl();
		List<Ticket> tickets = ts.getByCondition(null);
		//ts.saveAll(tickets);
		String result = StringUtil.convertToJsonQueryPara(tickets, getPage(), getRows());
		this.renderText(result);
		System.out.println("JSON" + result);
		return null;
	}

	public String link() throws Exception {
		return SUCCESS;
	}
	
	public String getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
}
