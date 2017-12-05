package lle.crud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "trade")
public class Trade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trade_nb")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String tradeNb;

	@Column(name = "instrument")
	private String instrument;

	@Column(name = "currency")
	private String currency;

	@Column(name = "portfolio")
	private String portfolio;

	// Join column: mapping data from trade to trade header
	@JoinColumns({ @JoinColumn(name = "trn_fmly", referencedColumnName = "trn_fmly"),
			@JoinColumn(name = "trn_grp", referencedColumnName = "trn_grp"),
			@JoinColumn(name = "trn_type", referencedColumnName = "trn_type") })
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TradeHeader tradeHeader;

	@Column(name = "trn_status")
	private String trnStatus;

	@Column(name = "input_date")
	private Date inputDate;

	// LLE: 31/11/2017 BEGIN
	@Column(name = "user_created")
	private Integer userCreatedId;

	@Column(name = "last_action", nullable = true)	
	private Integer lastActionId;

	@Column(name = "last_date", nullable = true)
	@Null
	private Date lastDate;

	@Column(name = "last_user", nullable = true)
	@Null
	private Integer lastUserId;
	// LLE: 31/11/2017 END

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "trade_issue", joinColumns = @JoinColumn(name = "trade_nb"), inverseJoinColumns = @JoinColumn(name = "issue_id"))
	List<Issue> issueList = new ArrayList<Issue>();

	public Trade() {
		super();
	}

	public Trade(String tradeNb, String instrument, String currency, String portfolio, TradeHeader tradeHeader,
			String trnStatus, Date inputDate, Integer userCreatedId, Integer lastActionId, Date lastDate,
			Integer lastUserId) {
		super();
		this.tradeNb = tradeNb;
		this.instrument = instrument;
		this.currency = currency;
		this.portfolio = portfolio;
		this.tradeHeader = tradeHeader;
		this.trnStatus = trnStatus;
		this.inputDate = inputDate;
		this.userCreatedId = userCreatedId;
		this.lastActionId = lastActionId;
		this.lastDate = lastDate;
		this.lastUserId = lastUserId;
	}
	
	/**@author LuanNgu
	 * @param t
	 * {@code copy creation}
	 */
	public Trade(Trade t)
	{
		this.tradeNb = t.tradeNb;
		this.instrument = t.instrument;
		this.currency = t.currency;
		this.portfolio = t.portfolio;
		this.tradeHeader = t.tradeHeader;
		this.trnStatus = t.trnStatus;
		this.inputDate = t.inputDate;
		this.userCreatedId = t.userCreatedId;
		this.lastActionId = t.lastActionId;
		this.lastDate = t.lastDate;
		this.lastUserId = t.lastUserId;
		this.issueList = new ArrayList<Issue>(t.getIssueList());
	}

	public String getTradeNb() {
		return tradeNb;
	}

	public void setTradeNb(String tradeNb) {
		this.tradeNb = tradeNb;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public TradeHeader getTradeHeader() {
		return tradeHeader;
	}

	public void setTradeHeader(TradeHeader tradeHeader) {
		this.tradeHeader = tradeHeader;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getUserCreatedId() {
		return userCreatedId;
	}

	public void setUserCreatedId(Integer userCreatedId) {
		this.userCreatedId = userCreatedId;
	}

	public Integer getLastActionId() {
		return lastActionId;
	}

	public void setLastActionId(Integer lastActionId) {
		this.lastActionId = lastActionId;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Integer getLastUserId() {
		return lastUserId;
	}

	public void setLastUserId(Integer lastUserId) {
		this.lastUserId = lastUserId;
	}

	public List<Issue> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<Issue> issueList) {
		this.issueList = issueList;
	}
	
}
