package com.ticket.yanyj.dao;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.emty.Ticket;

public interface TicketDAO {

	/**
	 * 保存单个实体
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
	 * 根据Id查询
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public Ticket get(String ID) throws Exception;
	
	/**
	 * 根据条件查询
	 * @author yanyj
	 * @date 2016年8月13日
	 */
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception;
	
	/**
	 * 更新实体
	 * @author yanyj
	 * @date 2016年8月14日
	 */
	public boolean update(Ticket ticket) throws Exception;
	
	/**
	 * 删除
	 * @author yanyj
	 * @date 2016年8月14日
	 */
	public boolean delete(String ID) throws Exception;
}
