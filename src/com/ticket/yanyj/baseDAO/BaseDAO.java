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
 * 
 */
public class BaseDAO {

	private static Connection con = JdbcUtil.createConnetionByDefalut();
	private static Statement st = JdbcUtil.getStatement(con);
	
	public int executeUpdate(String query, List<Object> args) throws Exception {
		
		return st.executeUpdate(StringUtil.replaceSql(query, args));
	}
	
	public int executeUpdate(String query) throws Exception {
			
		return st.executeUpdate(query);
	}
	
	public boolean execute(String query, List<Object> args) throws Exception {
		return st.execute(StringUtil.replaceSql(query, args));
	}
	
	public boolean execute(String query) throws Exception {
		return st.execute(query);
	}
	
	public ResultSet executeQuery(String query, List<Object> args) throws Exception {
		return st.executeQuery(StringUtil.replaceSql(query, args));
	}
	
	public ResultSet executeQuery(String query) throws Exception {
		return st.executeQuery(query);
	}
	
	public Statement getSt() {
		return st;
	}
	public Connection getCon() {
		return con;
	}
	
}
