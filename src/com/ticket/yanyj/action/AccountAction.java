package com.ticket.yanyj.action;

public class AccountAction extends BaseAction{
	private String amount;

	private static final long serialVersionUID = 1L;
	
	public String linkAccount() throws Exception{
		
		amount = String.valueOf(accountservice.getAmount());
		
		return SUCCESS;
	}
	public String capitalInput() throws Exception{
				
		return SUCCESS;
	}

	public String alterAmount() throws Exception {
		this.renderText(String.valueOf(accountservice.setAmount(Float.parseFloat(amount))));
		amount = String.valueOf(accountservice.getAmount());
		return null;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
