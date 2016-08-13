package com.ticket.yanyj.dao;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.emty.Ticket;

public interface TicketDAO {

	/**
	 * ����ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	public boolean save(Ticket ticket) throws Exception;

	/**
	 * ����ȫ��ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	public boolean saveAll(List<Ticket> ticketList) throws Exception;
	
	/**
	 * ͨ��ID��ȡ��Ʊʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	public Ticket get(String ID) throws Exception;
	
	/**
	 * ��������ɾѡ
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception;
}
