package com.ticket.yanyj.action;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ticket.yanyj.emty.Profit;
import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;
import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;

public class TicketAction extends BaseAction {
	private String ticketInfo;
	private String ID;
	private String endScore;
	private Profit profit;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3620686942578689657L;

	public String list() throws Exception {
		String now = LocalDate.now().toString();
		//向收益表中添加今天的数据信息
		if(profitService.get(now) == null) {
			profitService.add();
		}
		TicketService ts = new TIcketServiceImpl();
		List<Ticket> tickets = ts.getByCondition(null);
		//ts.saveAll(tickets);
		profit = profitService.get(now);
		String result = StringUtil.convertToJsonQueryPara(tickets, getPage(), getRows());
		this.renderText(result);
		
		return null;
	}
	
	/**
	 * 跟新利润
	 * @author yanyj
	 * @date 2016年8月19日
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		Ticket ticket =  ticketService.get(ID);
		String now = LocalDate.now().toString();
		ticket.setEndScore(endScore);
		
		BigDecimal profitT = new BigDecimal(Float.toString(TicketUtil.calutProfit(ticket))) ;
		BigDecimal profitBefo = new BigDecimal(Float.toString(ticket.getProfit())) ;
		ticket.setProfit(profitT.floatValue());
		
		ticketService.update(ticket);
		
//		if(profitT.floatValue() > 0) {
//			accountservice.changeAmount(profitT.add(new BigDecimal(ticket.getStake()).subtract(profitBefo)).floatValue());
//		} else if (profitT.floatValue() < 0) {
//			accountservice.changeAmount(new BigDecimal(0).subtract(new BigDecimal(ticket.getStake()).subtract(profitBefo)).floatValue());
//		}
		profit = profitService.get(now);
		if (ticket.getStatus() != 0) {
			if(profitBefo.floatValue() < 0) {
				accountservice.changeAmount(-profitBefo.floatValue());
			} else if (profitBefo.floatValue() > 0) {
				accountservice.changeAmount(- (new BigDecimal(Float.toString(ticket.getStake())).add(profitBefo)).floatValue());
			} else {
				accountservice.changeAmount(-new BigDecimal(Float.toString(ticket.getStake())).floatValue());
			}
			
		}
		profit.setBet_profit(new BigDecimal(Float.toString(profit.getBet_profit())).add(profitT).subtract(profitBefo).floatValue());
		
		if(ticket.getProfit() >= 0) {
			if(profitBefo.floatValue() < 0) {
				accountservice.changeAmount(profitT.floatValue());
			} else {
				accountservice.changeAmount(new BigDecimal(Float.toString(ticket.getStake())).add(profitT).floatValue());
			}
		} else {
			accountservice.changeAmount(profitT.add(new BigDecimal(Float.toString(ticket.getStake()))).floatValue());
		}
		
		profitService.update(profit);
		
		return null;
	}
	
	/**
	 * 跟新利润
	 * @author yanyj
	 * @date 2016年8月19日
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		//List<Ticket> ticket = TicketUtil.convertStringToTicketMap(StringUtil.removeSpaceCharater(ticketInfo));
		List<Ticket> ticketLst = TicketUtil.convertToTickets(StringUtil.splitInfoBySpace(ticketInfo));
		float count = 0.0f;
		ticketService.saveAll(ticketLst);
		String now = LocalDate.now().toString();
		//向收益表中添加今天的数据信息
		if(profitService.get(now) == null) {
			profitService.add();
		}
		//保存注单时，改变收益表中总注单金额
		Profit profit = profitService.get(now);
		for (Ticket ticket : ticketLst) {
			count += ticket.getStake();
			profit.setBet_amount(profit.getBet_amount() + ticket.getStake());
		}
		//修改账户表中的余额
		accountservice.changeAmount(0 - count);
		profitService.update(profit);
		
		List<Ticket> tickets = ticketService.getByCondition(null);
		String result = StringUtil.convertToJsonQueryPara(tickets, getPage(), getRows());
		this.renderText(result);
		return null;
	}
	
	/**
	 * ajax 获取profit信息
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public String getProfitInfo() throws Exception {
	
		String now = LocalDate.now().toString();
		profit = profitService.get(now);
		String profitInfo = JSON.toJSONString(profit);
		this.renderText(profitInfo);
		return null;
	}
	
	/**
	 * 转换路径方法
	 * @author yanyj
	 * @date 2016年8月22日
	 * @return
	 * @throws Exception
	 */
	public String link() throws Exception {
		String now = LocalDate.now().toString();
		if(profitService.get(now) == null) {
			profitService.add();
		}
		profit = profitService.get(now);
		return SUCCESS;
	}
	
	public String getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getEndScore() {
		return endScore;
	}
	
	public void setEndScore(String endScore) {
		this.endScore = endScore;
	}

	public Profit getProfit() {
		return profit;
	}

	public void setProfit(Profit profit) {
		this.profit = profit;
	}
}
