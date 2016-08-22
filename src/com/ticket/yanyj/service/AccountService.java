package com.ticket.yanyj.service;

public interface AccountService {

	/**
	 * 获取账户金额
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public float getAmount() throws Exception;
	
	/**
	 * 改变账户金额
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public boolean changeAmount(float amount) throws Exception;
	
	/**
	 * 设置账户金额
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public boolean setAmount(float amount) throws Exception;
}
