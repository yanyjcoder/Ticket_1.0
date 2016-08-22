package com.ticket.yanyj.service;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.emty.Profit;

public interface ProfitService {

	/**
	 * 添加实体
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public boolean add() throws Exception;
	
	/**
	 * 更新实体
	 * @author yanyj
	 * @date 2016年8月22日
	 * @param profit
	 * @return
	 * @throws Exception
	 */
	public boolean update(Profit profit) throws Exception;
	
	/**
	 * 根据条件查询盈利信息
	 * @author yanyj
	 * @date 2016年8月22日
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public List<Profit> get(Map<String, String> condition) throws Exception;
	
	/**
	 * 根据日期获取
	 * @author yanyj
	 * @date 2016年8月22日
	 * @param dateStr
	 * @return
	 * @throws Exception
	 */
	public Profit get(String dateStr) throws Exception;
}
