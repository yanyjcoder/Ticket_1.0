package com.ticket.yanyj.service.impl;

import com.ticket.yanyj.dao.AccountDAO;
import com.ticket.yanyj.dao.impl.AccountDAOImpl;
import com.ticket.yanyj.service.AccountService;

public class AccountServiceImpl implements AccountService {
	
	private static AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public float getAmount() throws Exception {
		return accountDAO.getAmount();
	}

	@Override
	public boolean changeAmount(float amount) throws Exception {
		return accountDAO.changeAmount(amount);
	}

	@Override
	public boolean setAmount(float amount) throws Exception {
		return accountDAO.setAmount(amount);
	}

}
