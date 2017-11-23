package lle.crud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trn_hdr")
public class TradeHeader implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TradeHeaderKey tradeHeaderKey;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "tradeHeader", fetch = FetchType.EAGER)
    private List<Trade> tradeList;	
	
	public TradeHeader() {
		super();
	}
	
	public TradeHeader(TradeHeaderKey tradeHeaderKey, String description) {
		super();
		this.tradeHeaderKey = tradeHeaderKey;
		this.description = description;
	}	
	
	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

	public TradeHeaderKey getTradeHeaderKey() {
		return tradeHeaderKey;
	}
	
	public void setTradeHeaderKey(TradeHeaderKey tradeHeaderKey) {
		this.tradeHeaderKey = tradeHeaderKey;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
