package com.ticket.yanyj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.ticket.yanyj.constant.TicketConstant;

public class JdbcUtil {

	private static final Logger log = Logger.getLogger("JdbcUtil.class");
	private static Connection con;
	
	public static Connection createConnetion(String JDriver, String Dbstr, String Dbuser, String Dbpassword) {
		  
		try {
			Class.forName(JDriver);// 加载数据库驱动
			log.info("数据库驱动加载成功！");
		} catch (ClassNotFoundException e) {
			log.info("数据库驱动加载失败！");
			log.info(e.getMessage());
			return null;
		}
		try {
			con = DriverManager.getConnection(Dbstr, Dbuser, Dbpassword);
			log.info("数据库连接成功！");
		} catch (SQLException e) {
			log.info("数据库连接失败！");
			log.info(e.getMessage());
			return null;
		} 
		
		return con;
	}

	public static Connection createConnetionByDefalut() {
		if(con != null) {
			return con;
		}
		return createConnetion(TicketConstant.STR_JDRIVER, TicketConstant.DB_STR, TicketConstant.DB_USER, TicketConstant.DB_PASSWORD);
	}
	
	
	public static Statement getStatement(Connection conn){
		Statement st = null;
		try {
			st = conn.createStatement();
			log.info("创建Statement成功！");
		} catch (SQLException e) {
			log.info("创建Statement失败！");
			log.info(e.getMessage());
		}
		
		return st;
	}
	
	public static boolean closeConnetion(Connection con) {
		if(con == null) {
			log.info("数据库未连接！");
			return true;
		}
		try {
			con.close();
			log.info("数据库已成功关闭！");
		} catch (SQLException e) {
			log.info("数据库关闭异常！");
			log.info(e.getMessage());
		}
		return true;
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		JdbcUtil.con = con;
	}
}
