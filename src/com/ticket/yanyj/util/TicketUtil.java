package com.ticket.yanyj.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ticket.yanyj.emty.Ticket;

/**
 * 彩票工具类
 * 
 * @author yanyj
 * @date 2016年7月30日
 */
public class TicketUtil {

	/**
	 * 计算收益
	 * 
	 * @author yanyj
	 * @date 2016年8月18日
	 * @描述
	 * @思路
	 * @param endScore
	 * @return
	 */
	public static float calutProfit(Ticket ticket) {
		// 获取两队的进球数
		String[] scoreArr = ticket.getEndScore().split("\\.");
		// 主队进球数
		int htScore = Integer.parseInt(scoreArr[0].trim());
		// 客队进球数
		int ctScore = Integer.parseInt(scoreArr[1].trim());
		int scoreNum = htScore + ctScore;
		float profit = 0.0f;
		// 判断是不是大小球
		if (ticket.getType().indexOf("大小") != -1) {
			int gmblType = 0;
			if (String.valueOf(ticket.getGmbl()).indexOf(".75") != -1) {
				// 0.75的情况
				gmblType = 1;
			} else if (String.valueOf(ticket.getGmbl()).indexOf(".25") != -1) {
				// 0.25的情况
				gmblType = 2;
			}
			profit = culteSizeBall(gmblType, scoreNum, ticket);
		}
		return profit;
	}

	/**
	 * 计算大小球规则
	 * @author yanyj
	 * @date 2016年8月18日
	 * @描述 BigDecimal 的方法  add +  subtract - multiply *    divide  /    remainder %  
	 * @思路
	 * @param gmblType
	 * @param ticket
	 * @return
	 */
	public static float culteSizeBall(int gmblType, int scoreNum, Ticket ticket) {
		BigDecimal profit = new BigDecimal("0.0");
		BigDecimal stake = new BigDecimal(Float.toString(ticket.getStake()));
		BigDecimal gmbl = new BigDecimal(Float.toString(ticket.getGmbl()));
		BigDecimal odds = new BigDecimal(Float.toString(ticket.getOdds()));
		BigDecimal scoreNumBig = new BigDecimal(scoreNum);
		
		switch (gmblType) {
		case 0: // 0.5 和 1 的情况
			if (scoreNumBig.subtract(gmbl).floatValue() > 0) {
				if (ticket.getBetType().indexOf("大") != -1) {
					profit = odds.multiply(stake);
				} else {
					profit = new BigDecimal("0.0f").subtract(stake);
				}
			} else if (scoreNumBig.subtract(gmbl).floatValue() < 0) {
				if (ticket.getBetType().indexOf("大") != -1) {
					profit =  new BigDecimal("0.0").subtract(stake);
				} else {
					profit = odds.multiply(stake);
				}
			} else {
				profit = new BigDecimal("0.0");
			}
			break;
		case 1://0.75 的情况
			if (ticket.getBetType().indexOf("大") != -1) {
				if(scoreNumBig.subtract(gmbl).floatValue() == 0.25f) {
					profit = odds.multiply(stake.divide(new BigDecimal("2.0")));
				} else if (scoreNumBig.subtract(gmbl).floatValue() > 0.5f) {
					profit = odds.multiply(stake);
				} else if (scoreNumBig.subtract(gmbl).floatValue() < 0.5f) {
					profit = new BigDecimal("0.0").subtract(stake);	
				}
			} else {
				if(scoreNumBig.subtract(gmbl).floatValue()  == 0.25f) {
					profit =  new BigDecimal("0.0").subtract(stake.divide(new BigDecimal("2.0")));
				} else if (scoreNumBig.subtract(gmbl).floatValue() > 0.5f) {
					profit = new BigDecimal("0.0").subtract(stake);
				} else if (scoreNumBig.subtract(gmbl).floatValue() < 0.5f) {
					profit = odds.multiply(stake);
				}
			}
			break;
		case 2:
			if (ticket.getBetType().indexOf("大") != -1) {
				if(scoreNumBig.subtract(gmbl).floatValue() == -0.25f) {
					profit = new BigDecimal("0.0").subtract(stake.divide(new BigDecimal("2.0")));
				} else if (scoreNumBig.subtract(gmbl).floatValue() > 0.5f) {
					profit = odds.multiply(stake);
				} else if (scoreNumBig.subtract(gmbl).floatValue() < 0.5f) {
					profit = new BigDecimal("0.0").subtract(stake);	
				}
			} else {
				if(scoreNumBig.subtract(gmbl).floatValue() == -0.25f) {
					profit = odds.multiply(stake.divide(new BigDecimal("2.0")));
				} else if (scoreNumBig.subtract(gmbl).floatValue() > 0.5f) {
					profit = new BigDecimal("0.0").subtract(stake);
				} else if (scoreNumBig.subtract(gmbl).floatValue() < 0.5f) {
					profit = odds.multiply(stake);
				}
			}
			break;
		default:
			break;
		}
		return profit.floatValue();
	}
	
	/**
	 * 将彩票字符串转换为List<Ticket>集合
	 * 
	 * @author yanyj
	 * @throws ParseException
	 * @date 2016年7月30日
	 */
	public static List<Ticket> convertStringToTicketMap(List<String> list) throws ParseException {

		List<Ticket> tickets = new ArrayList<Ticket>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Ticket ticket = null;
		String[] info = null;
		for (int i = 0; i < list.size(); i++) {
			switch (i % 8) {
			case 0:
				if (i != 0) {
					tickets.add(ticket);
				}
				ticket = new Ticket();
				ticket.setProfit(0);
				info = list.get(i).trim().split("/");
				ticket.setClazz(info[0]);
				ticket.setType(info[1]);
				break;
			case 1:
				ticket.setBetType(list.get(i).trim());
				break;
			case 2:// 将比率，即时比分和赔率注入实体
				info = list.get(i).split(" ");
				ticket.setGmbl(Float.parseFloat(info[0]));
				ticket.setJsbf(info[1].substring(0, info[1].length()));
				ticket.setOdds(Float.parseFloat(info[2].substring(1)));
				break;
			case 3:
				ticket.setStake(Float.parseFloat(list.get(i).trim()));
				break;
			case 4:
				ticket.setTeam(list.get(i).trim());
				break;
			case 5:
				ticket.setID(list.get(i).substring(3));
				break;
			case 6:
				break;
			case 7:
				info = list.get(i).split(" ");
				ticket.setDate(sdf.parse(info[0].replaceAll("/", "-") + " " + info[2]));
				break;
			default:
				break;
			}

		}

		return tickets;

	}
	
	
	/**
	 * 新的字符串数组转换为Ticket集合
	 * @author yanyj
	 * @date 2016年8月22日
	 * @描述
	 * @思路
	 * @param ticketInfo
	 * @return
	 * @throws Exception
	 */
	public static List<Ticket> convertToTickets(String[] ticketInfo) throws Exception{
		List<Ticket> ticketList = new ArrayList<>();
		Ticket ticket = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int infoLgt = ticketInfo.length;
		for (int i = 0; i < infoLgt; i++) {
			if (ticketInfo[i].equals("足球")) {
				ticket = new Ticket();
				ticket.setClazz(ticketInfo[i].trim());
				i = i + 2;
				ticket.setType(ticketInfo[i].trim());
				i = i + 1;
				ticket.setBetType(ticketInfo[i].trim());
				i = i + 1;
				ticket.setGmbl(Float.parseFloat(ticketInfo[i].trim()));
				i = i + 1;
				ticket.setJsbf(ticketInfo[i].trim().substring(0, ticketInfo[i].length()));
				i = i + 1;
				ticket.setOdds(Float.parseFloat(ticketInfo[i].trim().substring(1)));
				i = i + 1;
				ticket.setStake(Float.parseFloat(ticketInfo[i].trim()));
				i = i + 1;
				String teamStr = ticketInfo[i].trim();
				while (!ticketInfo[i + 1].contains("ID:")) {
					i ++;
					teamStr += " " + ticketInfo[i].trim();
				}
				ticket.setTeam(teamStr.trim());
				i = i + 1;
				ticket.setID(ticketInfo[i].substring(3, ticketInfo[i].length() - 3).trim());
				i = i + 1;
				String dateStr = ticketInfo[i].trim() + " " + ticketInfo[i + 2].trim();
				ticket.setDate(sdf.parse(dateStr.replaceAll("/", "-")));
				
				ticketList.add(ticket);
				}
		}
		
		return ticketList;
	}
}
