package com.ticket.yanyj.service.impl;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.dao.TicketDAO;
import com.ticket.yanyj.dao.impl.TicketDAOImpl;
import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.service.TicketService;

public class TIcketServiceImpl implements TicketService {
	
	private static TicketDAO ticketDAO = new TicketDAOImpl(); 

	/**
	 * 保存实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	@Override
	public boolean save(Ticket ticket) throws Exception {
		return ticketDAO.save(ticket);
	}

	/**
	 * 保存全部实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	@Override
	public boolean saveAll(List<Ticket> ticketList) throws Exception {
		return ticketDAO.saveAll(ticketList);
	}

	/**
	 * 通过ID获取彩票实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	@Override
	public Ticket get(String ID) throws Exception {
		return ticketDAO.get(ID);
	}

	/**
	 * 根据条件删选
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	@Override
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception {
		return ticketDAO.getByCondition(condition);
	}
	
	/**
	 * 跟新
	 * @author yanyj
	 * @date 2016年8月14日
	 */
	@Override
	public boolean update(Ticket ticket) throws Exception {
		return ticketDAO.update(ticket);
	}
}
