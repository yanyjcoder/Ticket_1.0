package com.ticket.yanyj.emty;

/**
 * 盈利实体类
 * @author yanyj
 * @date 2016年8月22日
 */
public class Profit {

	//当前日期
	private String date;
	//账户余额
	private float balance;
	//当前投注金额
	private float bet_amount;
	//当前盈利
	private float bet_profit;
	
	/** get 和 set 方法 **/
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getBet_amount() {
		return bet_amount;
	}
	public void setBet_amount(float bet_amount) {
		this.bet_amount = bet_amount;
	}
	public float getBet_profit() {
		return bet_profit;
	}
	public void setBet_profit(float bet_profit) {
		this.bet_profit = bet_profit;
	}
	
	@Override
	public String toString() {
		return date + "|" + balance + "|" + bet_amount + "|" + bet_profit;
	}
}
