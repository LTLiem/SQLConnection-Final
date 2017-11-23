package lle.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TradeIssueMapKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="trade_nb")
	private String tradeNb;
	
	@Column(name="issue_id")
	private int issueId;
	
	public TradeIssueMapKey() {
		super();
	}

	public TradeIssueMapKey(String tradeNb, int issueId) {
		super();
		this.tradeNb = tradeNb;
		this.issueId = issueId;
	}

	public String getTradeNb() {
		return tradeNb;
	}

	public void setTradeNb(String tradeNb) {
		this.tradeNb = tradeNb;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
		
}
