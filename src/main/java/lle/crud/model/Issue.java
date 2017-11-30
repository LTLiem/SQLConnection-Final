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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "issue_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int issueId;

	@Column(name = "field")
	private String field;

	@Column(name = "report")
	private String report;

	@Column(name = "sql_filter")
	private String sqlFilter;

	@Column(name = "correct_source")
	private String correctSource;

	@Column(name = "different_type")
	private String differentType;

	@Column(name = "explanation")
	private String explanation;

	@Column(name = "field_value")
	private String fieldValue;

	@Column(name = "input_date")
	private Date inputDate;

	// LLE: 31/11/2017 BEGIN

	// Join column: mapping issue from user to status
	/*
	 * @JoinColumn(name="status", referencedColumnName="status_id")
	 * 
	 * @ManyToOne(optional = false, fetch = FetchType.EAGER)
	 */

	@Column(name = "status")
	private Integer statusId;

	@Column(name = "user_created")
	private Integer userCreatedId;

	@Column(name = "last_action", nullable = true)
	private Integer lastActionId;

	@Column(name = "last_date", nullable = true)
	private Date lastDate;

	@Column(name = "last_user", nullable = true)
	private Integer lastUserId;
	// LLE: 31/11/2017 END

	@ManyToMany(mappedBy = "issueList", fetch = FetchType.EAGER)
	List<Trade> tradeList = new ArrayList<Trade>();

	public Issue() {
		super();
	}

	public Issue(int issueId, String field, String report, String sqlFilter, String correctSource, String differentType,
			String explanation, String fieldValue, Date inputDate, Integer statusId, Integer userCreatedId,
			Integer lastActionId, Date lastDate, Integer lastUserId) {
		super();
		this.issueId = issueId;
		this.field = field;
		this.report = report;
		this.sqlFilter = sqlFilter;
		this.correctSource = correctSource;
		this.differentType = differentType;
		this.explanation = explanation;
		this.fieldValue = fieldValue;
		this.inputDate = inputDate;
		this.statusId = statusId;
		this.userCreatedId = userCreatedId;
		this.lastActionId = lastActionId;
		this.lastDate = lastDate;
		this.lastUserId = lastUserId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getSqlFilter() {
		return sqlFilter;
	}

	public void setSqlFilter(String sqlFilter) {
		this.sqlFilter = sqlFilter;
	}

	public String getCorrectSource() {
		return correctSource;
	}

	public void setCorrectSource(String correctSource) {
		this.correctSource = correctSource;
	}

	public String getDifferentType() {
		return differentType;
	}

	public void setDifferentType(String differentType) {
		this.differentType = differentType;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

}
