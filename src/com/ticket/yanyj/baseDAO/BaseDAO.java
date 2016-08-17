package com.ticket.yanyj.baseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.util.JdbcUtil;
import com.ticket.yanyj.util.StringUtil;

/**
 * DAO的顶层类，封装一些常用的方法和属性
 * @author yanyj
 * @date 2016年8月12日
 * 
 */
public class BaseDAO {

	private static Connection con = JdbcUtil.createConnetionByDefalut();
	
	
	public int executeUpdate(String query, List<Object> args) throws Exception {
		
		PreparedStatement pst = con.prepareStatement(StringUtil.replaceSql(query, args));
		return pst.executeUpdate();
	}
	
	public int executeUpdate(String query) throws Exception {
			
		PreparedStatement pst = con.prepareStatement(query);
		return pst.executeUpdate();
	}
	
	public boolean execute(String query, List<Object> args) throws Exception {
		PreparedStatement pst = con.prepareStatement(StringUtil.replaceSql(query, args));
		return pst.execute();
	}
	
	public boolean execute(String query) throws Exception {
		PreparedStatement pst = con.prepareStatement(query);
		return pst.execute();
	}
	
	public List<Ticket> executeQuery(String query, List<Object> args) throws Exception {
		PreparedStatement pst = con.prepareStatement(StringUtil.replaceSql(query, args));
		ResultSet rs = pst.executeQuery();
		Ticket ticket = null;
		List<Ticket> ticketLst = new ArrayList<>();
			while(rs.next()){
				ticket = new Ticket();
				ticket .setID(rs.getString("ID"));
				ticket.setClazz(rs.getString("class"));
				ticket.setBetType(rs.getString("betType"));
				ticket.setDate(rs.getTimestamp("date"));
				ticket.setEndScore(rs.getString("endScore"));
				ticket.setGmbl(rs.getFloat("gmbl"));
				ticket.setJsbf(rs.getString("jsbf"));
				ticket.setOdds(rs.getFloat("odds"));
				ticket.setStake(rs.getFloat("stake"));
				ticket.setTeam(rs.getString("team"));
				ticket.setType(rs.getString("type"));
				ticketLst.add(ticket);
			
		}
		return ticketLst;
	}
	
	public List<Ticket> executeQuery(String query) throws Exception {
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		Ticket ticket = null;
		List<Ticket> ticketLst = new ArrayList<>();
		while (rs.next()) {
			while(rs.next()){
				ticket = new Ticket();
				ticket .setID(rs.getString("ID"));
				ticket.setClazz(rs.getString("class"));
				ticket.setBetType(rs.getString("betType"));
				ticket.setDate(rs.getTimestamp("date"));
				ticket.setEndScore(rs.getString("endScore"));
				ticket.setGmbl(rs.getFloat("gmbl"));
				ticket.setJsbf(rs.getString("jsbf"));
				ticket.setOdds(rs.getFloat("odds"));
				ticket.setStake(rs.getFloat("stake"));
				ticket.setTeam(rs.getString("team"));
				ticket.setType(rs.getString("type"));
				ticketLst.add(ticket);
			}
		}
		return ticketLst;
	}
	
	public Connection getCon() {
		return con;
	}

	
}
