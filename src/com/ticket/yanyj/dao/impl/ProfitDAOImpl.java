package com.ticket.yanyj.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.ticket.yanyj.baseDAO.BaseDAO;
import com.ticket.yanyj.dao.AccountDAO;
import com.ticket.yanyj.dao.ProfitDAO;
import com.ticket.yanyj.emty.Profit;

public class ProfitDAOImpl extends BaseDAO implements ProfitDAO {

	private static AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public boolean add() throws Exception {
		LocalDate ld = LocalDate.now();
		String sql = "insert into t_profit values(?,?,?,?)";
		PreparedStatement pst = getCon().prepareStatement(sql);
		pst.setString(1, ld.toString());
		pst.setFloat(2, accountDAO.getAmount());
		pst.setFloat(3, 0.0f);
		pst.setFloat(4, 0.0f);
		
		return pst.executeUpdate() != -1 ? true : false;
	}

	@Override
	public boolean update(Profit profit) throws Exception {
		String sql = "update t_profit set balance = ?, bet_amount = ?, bet_profit = ? where date = ?";
		PreparedStatement pst = getCon().prepareStatement(sql);
		//应该去账户余额表中查询
		pst.setFloat(1, accountDAO.getAmount());
		pst.setFloat(2, profit.getBet_amount());
		pst.setFloat(3, profit.getBet_profit());
		pst.setString(4, profit.getDate());
		return pst.executeUpdate() > 0;
	}

	@Override
	public List<Profit> get(Map<String, String> condition) throws Exception {
		//String sql = "select * from t_ticket where date != null ";
		
		return null;
	}

	@Override
	public Profit get(String dateStr) throws Exception {
		String sql = "select * from t_profit where date = ?";
		PreparedStatement pst = getCon().prepareStatement(sql);
		pst.setString(1, dateStr);
		ResultSet rs = pst.executeQuery();
		Profit profit = null;
		while (rs.next()) {
			profit = new Profit();
			profit.setDate(dateStr);
			profit.setBalance(rs.getFloat("balance"));
			profit.setBet_amount(rs.getFloat("bet_amount"));
			profit.setBet_profit(rs.getFloat("bet_profit"));
		}
		return profit;
	}

}
