package com.ticket.yanyj.action;

public class AccountAction extends BaseAction{
	private float amount;

	private static final long serialVersionUID = 1L;
	
	public String linkAccount() throws Exception{
		
		amount = accountservice.getAmount();
		
		return SUCCESS;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
