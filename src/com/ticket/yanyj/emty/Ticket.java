package com.ticket.yanyj.emty;

import java.util.Date;

/**
 * 彩票实体类
 * @author yanyj
 * @date 2016年7月30日
 */  
public class Ticket {

	//彩票ID
	private String ID;
	//彩票种类
	private String clazz;
	//彩票类型
	private String type;
	//购彩时间
	private Date date;
	//购买种类
	private String betType;
	//购买金额
	private float stake;
	//主队
	private String team;
	//即时比分
	private String jsbf;
	//结束比分
	private String endScore;
	//赔率
	private float odds;
	//购买比率
	private float gmbl;
	//删除标志
	private String deleteFlag;
	//盈利
	private float profit;
	
	/**构造方法*/
	public Ticket() {
	}

	/**setter 和 getter方法*/
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBetType() {
		return betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public float getStake() {
		return stake;
	}
	
	public void setStake(float stake) {
		this.stake = stake;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getJsbf() {
		return jsbf;
	}

	public void setJsbf(String jsbf) {
		this.jsbf = jsbf;
	}

	public String getEndScore() {
		return endScore;
	}
	
	public void setEndScore(String endScore) {
		this.endScore = endScore;
	}
 
	public float getOdds() {
		return odds;
	}

	public void setOdds(float odds) {
		this.odds = odds;
	}
	
	public float getGmbl() {
		return gmbl;
	}

	public void setGmbl(float gmbl) {
		this.gmbl = gmbl;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}
	
	
}
