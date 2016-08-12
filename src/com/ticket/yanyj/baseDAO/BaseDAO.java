package com.ticket.yanyj.baseDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.ticket.yanyj.util.JdbcUtil;
import com.ticket.yanyj.util.StringUtil;

/**
 * DAO的顶层类，封装一些常用的方法和属性
 * @author yanyj
 * @date 2016年8月12日
 */
public class BaseDAO {

	private Connection con = JdbcUtil.createConnetionByDefalut();
	private Statement st = JdbcUtil.getStatement(getCon());
	
	public int executeUpdate(String query, List<Object> args) throws Exception {
		
		return st.executeUpdate(StringUtil.replaceSql(query, args));
	}
	
	public boolean execute(String query, List<Object> args) throws Exception {
		return st.execute(StringUtil.replaceSql(query, args));
	}
	
	public ResultSet executeQuery(String query, List<Object> args) throws Exception {
		return st.executeQuery(StringUtil.replaceSql(query, args));
	}
	
	public Statement getSt() {
		return st;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setSt(Statement st) {
		this.st = st;
	}
}
