package com.ticket.yanyj.service;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.emty.Ticket;

/**
 * TicketService�ӿ�
 * @author yanyj
 * @date 2016��8��13��
 */
public interface TicketService {

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
	
	/**
	 * ����
	 * @author yanyj
	 * @date 2016��8��14��
	 */
	public boolean update(Ticket ticket) throws Exception;
}
