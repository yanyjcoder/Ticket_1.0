package com.ticket.yanyj.service;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.emty.Ticket;

/**
 * TicketService接口
 * @author yanyj
 * @date 2016年8月13日
 */
public interface TicketService {

	/**
	 * 保存实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public boolean save(Ticket ticket) throws Exception;
	
	/**
	 * 保存全部实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public boolean saveAll(List<Ticket> ticketList) throws Exception;
	
	/**
	 * 通过ID获取彩票实体
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public Ticket get(String ID) throws Exception;
	
	/**
	 * 根据条件删选
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception;
	
	/**
	 * 跟新
	 * @author yanyj
	 * @date 2016年8月14日
	 */
	public boolean update(Ticket ticket) throws Exception;
}
