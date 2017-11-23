package lle.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TradeHeaderKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="trn_fmly")
	private String trnFmly;
	
	@Column(name="trn_grp")
	private String trnGrp;
	
	@Column(name="trn_type")
	private String trnType;
	
	public TradeHeaderKey() {
		super();
	}
	public TradeHeaderKey(String trnFmly, String trnGrp, String trnType) {
		super();
		this.trnFmly = trnFmly;
		this.trnGrp = trnGrp;
		this.trnType = trnType;
	}
	public String getTrnFmly() {
		return trnFmly;
	}
	public void setTrnFmly(String trnFmly) {
		this.trnFmly = trnFmly;
	}
	public String getTrnGrp() {
		return trnGrp;
	}
	public void setTrnGrp(String trnGrp) {
		this.trnGrp = trnGrp;
	}
	public String getTrnType() {
		return trnType;
	}
	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}
	
}
