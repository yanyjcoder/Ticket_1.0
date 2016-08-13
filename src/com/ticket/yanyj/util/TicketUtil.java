package com.ticket.yanyj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ticket.yanyj.emty.Ticket;

/**
 * ��Ʊ������
 * @author yanyj
 * @date 2016��7��30��
 */
public class TicketUtil {

	/**
	 *����Ʊ�ַ���ת��ΪList<Ticket>����
	 * @author yanyj
	 * @throws ParseException 
	 * @date 2016��7��30��
	 */
	public static List<Ticket> convertStringToTicketMap(List<String> list) throws ParseException {
		
		List<Ticket> tickets = new ArrayList<Ticket>();
		SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		Ticket ticket = null;
		String[] info = null;
		for (int i = 0 ; i < list.size(); i++) {
			switch (i % 8) {
			case 0:
				if (i != 0) {
					tickets.add(ticket);
				}
				ticket = new Ticket();
				info = list.get(i).trim().split("/");
				ticket.setClazz(info[0]);
				ticket.setType(info[1]);
				break;
			case 1:
				ticket.setBetType(list.get(i).trim());
				break;
			case 2://�����ʣ���ʱ�ȷֺ�����ע��ʵ��
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
				ticket.setID(list.get(i));
				break;
			case 6:
				break;
			case 7:
				info = list.get(i).split(" ");
				ticket.setDate(sdf.parse(" " + info[0].replaceAll("/", "-") + " " +info[2]));
				break;
			default:
				break;
			}
			
		}
		
		return tickets;
		
	} 
}
