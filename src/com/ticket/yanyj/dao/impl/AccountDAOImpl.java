package com.ticket.yanyj.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ticket.yanyj.baseDAO.BaseDAO;
import com.ticket.yanyj.dao.AccountDAO;

public class AccountDAOImpl extends BaseDAO implements AccountDAO {

	@Override
	public float getAmount() throws Exception {
		String sql = "select * from t_account where username= 'yanyj'";
		float amount = 0.0f;
		PreparedStatement pst = this.getCon().prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			amount = rs.getFloat("amount");
		}
		return amount;
	}

	@Override
	public boolean changeAmount(float amount) throws Exception {
		String sql = "update t_account set amount = ? where username= 'yanyj'";
		PreparedStatement pst = getCon().prepareStatement(sql);
		pst.setFloat(1, getAmount() + amount);
		
		return pst.executeUpdate() > 0;
	}

	@Override
	public boolean setAmount(float amount) throws Exception {

		return false;
	}

}
