package com.ticket.yanyj.service.impl;

import java.util.List;
import java.util.Map;

import com.ticket.yanyj.dao.ProfitDAO;
import com.ticket.yanyj.dao.impl.ProfitDAOImpl;
import com.ticket.yanyj.emty.Profit;
import com.ticket.yanyj.service.ProfitService;

public class ProfitServiceImpl implements ProfitService{
	
	private static ProfitDAO profitDAO = new ProfitDAOImpl();
	
	@Override
	public boolean add() throws Exception {
		return profitDAO.add();
	}

	@Override
	public boolean update(Profit profit) throws Exception {
		return  profitDAO.update(profit);
	}

	@Override
	public List<Profit> get(Map<String, String> condition) throws Exception {
		return null;
	}

	@Override
	public Profit get(String dateStr) throws Exception {
		return profitDAO.get(dateStr);
	}

}
