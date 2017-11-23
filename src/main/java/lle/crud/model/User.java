package lle.crud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "actived_date")
	private String activedDate;
	
	@Column(name = "status")
	private String status;
	
	// Join column: mapping data from user to trade role
	@JoinColumn(name="role", referencedColumnName="role_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Role role;

/*	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Trade> tradeList;
	
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Issue> issueList;*/
	
	public User() {
		super();
	}

	public User(int userId, String name, String pwd, String activedDate, String status, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.pwd = pwd;
		this.activedDate = activedDate;
		this.status = status;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getActivedDate() {
		return activedDate;
	}

	public void setActivedDate(String activedDate) {
		this.activedDate = activedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}	
