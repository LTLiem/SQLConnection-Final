package lle.crud.dao;

import java.util.List;

import lle.crud.model.Issue;

public interface IssueDao extends Dao<Issue> {
	//Add specified method for Issue
	public List<Issue> getIssueByCreatedUserId(Integer userId);
}
