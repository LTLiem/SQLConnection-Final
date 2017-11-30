package lle.crud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statusId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "comment")
	private String comment;
	
/*	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<Issue> issueList;
*/
	public Status() {
		super();
	}

	public Status(int statusId, String status, String comment) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.comment = comment;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
