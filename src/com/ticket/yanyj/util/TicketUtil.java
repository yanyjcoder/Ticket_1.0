package com.ticket.yanyj.util;

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
	 * @描述
	 * @思路
	 * @param gmblType
	 * @param ticket
	 * @return
	 */
	public static float culteSizeBall(int gmblType, int scoreNum, Ticket ticket) {
		float profit = 0.0f;
		float stake = ticket.getStake();
		float gmbl = ticket.getGmbl();
		float odds = ticket.getOdds();
		switch (gmblType) {
		case 0: // 0.5 和 1 的情况
			if ((scoreNum - gmbl) > 0) {
				if (ticket.getBetType().indexOf("大") != -1) {
					profit = odds * stake;
				} else {
					profit = 0.0f - stake;
				}
			} else if ((scoreNum - gmbl) <= 0) {
				if (ticket.getBetType().indexOf("大") != -1) {
					profit = 0.0f - stake;
				} else {
					profit = odds * stake;
				}
			}
			break;
		case 1://0.75 的情况
			if (ticket.getBetType().indexOf("大") != -1) {
				if((scoreNum - gmbl) < 0.0f) {
					profit = 0.0f - stake;	
				} else if ((scoreNum - gmbl) > 0.5f) {
					profit = odds * stake;
				} else if ((scoreNum - gmbl) < 0.5f) {
					profit = odds * (stake / 2.0f);
				}
			} else {
				if((scoreNum - gmbl) < 0.0f) {
					profit = odds * stake;
				} else if ((scoreNum - gmbl) > 0.5f) {
					profit = 0.0f - stake;
				} else if ((scoreNum - gmbl) < 0.5f) {
					profit =  0.0f - (stake / 2.0f);
				}
			}
			break;
		case 2:
			if (ticket.getBetType().indexOf("大") != -1) {
				if((scoreNum - gmbl) < 0) {
					profit = 0.0f - stake;	
				} else if ((scoreNum - gmbl) > 0.5f) {
					profit = odds * stake;
				} else if ((scoreNum - gmbl) < 0.5f) {
					profit =  0.0f - (stake / 2.0f);
				}
			} else {
				if((scoreNum - gmbl) < 0.0f) {
					profit = odds * stake;
				} else if ((scoreNum - gmbl) > 0.5f) {
					profit = 0.0f - stake;
				} else if ((scoreNum - gmbl) < 0.5f) {
					profit = odds * (stake / 2.0f);
				}
			}
			break;
		default:
			break;
		}
		return profit;
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
}
