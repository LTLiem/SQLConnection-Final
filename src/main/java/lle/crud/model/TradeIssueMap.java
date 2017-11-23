package lle.crud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trade_issue")
public class TradeIssueMap implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TradeIssueMapKey tradeIssueMapKey;
	
	@Column(name="input_date")
	private Date inputDate;

	public TradeIssueMap() {
		super();
	}

	public TradeIssueMap(TradeIssueMapKey tradeIssueMapKey, Date inputDate) {
		super();
		this.tradeIssueMapKey = tradeIssueMapKey;
		this.inputDate = inputDate;
	}

	public TradeIssueMapKey getTradeIssueMapKey() {
		return tradeIssueMapKey;
	}

	public void setTradeIssueMapKey(TradeIssueMapKey tradeIssueMapKey) {
		this.tradeIssueMapKey = tradeIssueMapKey;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
}
