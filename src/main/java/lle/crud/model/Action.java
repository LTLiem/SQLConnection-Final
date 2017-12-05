package lle.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "action")
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "action_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actionId;

	@Column(name = "action")
	private String action;

	@Column(name = "comment")
	private String comment;

	public Action() {
		super();
	}

	public Action(int actionId, String action, String comment) {
		super();
		this.actionId = actionId;
		this.action = action;
		this.comment = comment;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
