package com.ticket.yanyj.constant;

/**
 * 常量类
 * @author yanyj
 * @date 2016年8月12日
 */
public class TicketConstant {

	//数据库连接常量
//	public static final String STR_JDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String STR_JDRIVER="net.sourceforge.jtds.jdbc.Driver";
	public static final String DB_STR="jdbc:jtds:sqlserver://121.40.167.171:1433;DatabaseName=ticket_test";
	public static final String DB_USER="yanyj";
	public static final String DB_PASSWORD="jun";
	//未删除
	public static final String DeleteFlag_NO = "0";
	//已删除
	public static final String DeleteFlag_YES = "1";
}
