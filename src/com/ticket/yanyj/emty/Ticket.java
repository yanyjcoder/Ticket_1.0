package com.ticket.yanyj.emty;

import java.util.Date;

/**
 * ��Ʊʵ����
 * @author yanyj
 * @date 2016��7��30��
 */  
public class Ticket {

	//��ƱID
	private String ID;
	//��Ʊ����
	private String clazz;
	//��Ʊ����
	private String type;
	//����ʱ��
	private Date date;
	//��������
	private String betType;
	//������
	private float stake;
	//����
	private String team;
	//��ʱ�ȷ�
	private String jsbf;
	//�����ȷ�
	private String endScore;
	//����
	private float odds;
	//�������
	private float gmbl;
	//ɾ����־
	private String deleteFlag;
	
	/**���췽��*/
	public Ticket() {
	}

	/**setter �� getter����*/
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
	
	
}
