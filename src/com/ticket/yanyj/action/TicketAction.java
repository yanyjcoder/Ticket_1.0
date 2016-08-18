package com.ticket.yanyj.action;

import java.util.List;

import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;
import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;

public class TicketAction extends BaseAction{
	private String ticketInfo;
	private String ID;
	private String endScore;
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
		return null;
	}
	public String update() throws Exception {
		Ticket ticket =  ticketService.get(ID);
		ticket.setEndScore(endScore);
		float profit = TicketUtil.calutProfit(ticket);
		System.out.println(profit);
		ticket.setProfit(profit);
		ticketService.update(ticket);
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEndScore() {
		return endScore;
	}
	public void setEndScore(String endScore) {
		this.endScore = endScore;
	}
}
