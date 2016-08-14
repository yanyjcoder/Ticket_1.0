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
	 * ����ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public boolean save(Ticket ticket) throws Exception {
		return ticketDAO.save(ticket);
	}

	/**
	 * ����ȫ��ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public boolean saveAll(List<Ticket> ticketList) throws Exception {
		return ticketDAO.saveAll(ticketList);
	}

	/**
	 * ͨ��ID��ȡ��Ʊʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public Ticket get(String ID) throws Exception {
		return ticketDAO.get(ID);
	}

	/**
	 * ��������ɾѡ
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception {
		return ticketDAO.getByCondition(condition);
	}
	
	/**
	 * ����
	 * @author yanyj
	 * @date 2016��8��14��
	 */
	@Override
	public boolean update(Ticket ticket) throws Exception {
		return ticketDAO.update(ticket);
	}
}
