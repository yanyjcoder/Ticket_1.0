package com.ticket.yanyj.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ticket.yanyj.baseDAO.BaseDAO;
import com.ticket.yanyj.constant.TicketConstant;
import com.ticket.yanyj.dao.TicketDAO;
import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.util.StringUtil;

public class TicketDAOImpl extends BaseDAO implements TicketDAO {

	private static final Logger log = Logger.getLogger("TicketDAOImpl");
	
	/**
	 * ����ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public boolean save(Ticket ticket) throws Exception {
		
		StringBuilder sql = new StringBuilder("insert into t_ticket values(?,?,?,?,?,?,?,?,?,?,?,?)");
		PreparedStatement pst = getCon().prepareStatement(sql.toString());
		pst.setString(1, ticket.getID());
		pst.setString(2, ticket.getClazz());
		pst.setString(3, ticket.getType());
//		pst.setDate(4, new Date(ticket.getDate().getTime()));
		pst.setTimestamp(4, new Timestamp(ticket.getDate().getTime()));
		pst.setString(5, ticket.getBetType());
		pst.setFloat(6, ticket.getStake());
		pst.setString(7, ticket.getTeam());
		pst.setString(8, ticket.getJsbf());
		pst.setString(9, ticket.getEndScore());
		pst.setFloat(10, ticket.getOdds());
		pst.setFloat(11, ticket.getGmbl());
		pst.setString(12, "0");
		
		return pst.executeUpdate() != -1 ? true : false;
	}

	/**
	 * ����ʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public boolean saveAll(List<Ticket> ticketlist) throws Exception {
		
		for (Ticket ticket : ticketlist) {
			try {
				save(ticket);
			} catch(SQLException s) {
				log.error(" [saveAll] ����ʵ��ʧ�ܣ�ʵ��Ϊ" + ticket.getID());
				log.error(s.getMessage());
			}
		}
		log.info(" [success] ȫ���ɹ���");
		return true;
	}
	
	/**
	 * ͨ��ID��ȡ��Ʊʵ��
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public Ticket get(String ID) throws Exception {
		
		List<Object> lst = new ArrayList<Object>();
		String sql = " select * from t_ticket where ID = ?";
		lst.add(ID);
		executeQuery(sql, lst);
		return executeQuery(sql, lst).get(0);
	};
	
	/**
	 * ��������ɾѡ
	 * @author yanyj
	 * @date 2016��8��13��
	 */
	@Override
	public List<Ticket> getByCondition(Map<String, Object> condition) throws Exception {
		
		List<Object> args = new ArrayList<>();
		StringBuilder sql = new StringBuilder("select * from t_ticket where deleteFlag = ?");
		args.add(TicketConstant.DeleteFlag_NO);
		if(condition != null ) {
			//��ɾѡ������ɾѡ����
			String ID = (String) condition.get("ID");
			String clazz = (String) condition.get("class");
			String betType = (String) condition.get("betType");
			String date = (String) condition.get("date");
			String endScore = (String) condition.get("endScore");
			String gmbl = (String) condition.get("gmbl");
			String jsbf = (String) condition.get("jsbf");
			String odds = (String) condition.get("odds");
			String stake = (String) condition.get("stake");
			String team = (String) condition.get("team");
			String type = (String) condition.get("type");
			if(StringUtil.isNotNull(ID)) {
				sql.append(" and ID = ?");
				args.add(ID);
			}
			if(StringUtil.isNotNull(clazz)) {
				sql.append(" and clazz = ?");
				args.add(clazz);
			}
			if(StringUtil.isNotNull(betType)) {
				sql.append(" and betType = ?");
				args.add(betType);
			}
			if(StringUtil.isNotNull(date)) {
				sql.append(" and date = ?");
				args.add(date);
			}
			if(StringUtil.isNotNull(endScore)) {
				sql.append(" and endScore = ?");
				args.add(endScore);
			}
			if(StringUtil.isNotNull(gmbl)) {
				sql.append(" and gmbl = ?");
				args.add(gmbl);
			}
			if(StringUtil.isNotNull(jsbf)) {
				sql.append(" and jsbf = ?");
				args.add(jsbf);
			}
			if(StringUtil.isNotNull(odds)) {
				sql.append(" and odds = ?");
				args.add(odds);
			}
			if(StringUtil.isNotNull(stake)) {
				sql.append(" and stake = ?");
				args.add(stake);
			}
			if(StringUtil.isNotNull(team)) {
				sql.append(" and team = ?");
				args.add(team);
			}
			if(StringUtil.isNotNull(type)) {
				sql.append(" and type = ?");
				args.add(type);
			}
		}
		return executeQuery(sql.toString(), args);
	}
	
	/**
	 * ����
	 * @author yanyj
	 * @date 2016��8��14��
	 */
	@Override
	public boolean update(Ticket ticket) throws Exception {
		String sql = "update t_ticket set class = ?,betType = ?,date = ?,endScore = ?,"
				+ "gmbl = ?,jsbf = ?,odds = ?,stake = ?,team = ?,type = ?, deleteFlag = ? where ID = ?";
		List<Object> args = new ArrayList<>();
		args.add(ticket.getClazz());
		args.add(ticket.getBetType());
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		args.add(sdf.format(ticket.getDate()));
		args.add(ticket.getEndScore());
		args.add(ticket.getGmbl());
		args.add(ticket.getJsbf());
		args.add(ticket.getOdds());
		args.add(ticket.getStake());
		args.add(ticket.getTeam());
		args.add(ticket.getType());
		args.add(ticket.getDeleteFlag());
		args.add(ticket.getID());
		return executeUpdate(sql,args) > 0;
	}

	/**
	 * ɾ��
	 * @author yanyj
	 * @date 2016��8��14��
	 */
	@Override
	public boolean delete(String ID) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}