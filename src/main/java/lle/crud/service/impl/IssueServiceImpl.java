package lle.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lle.crud.dao.IssueDao;
import lle.crud.model.Issue;
import lle.crud.service.IssueService;

@Service("IssueService")
@Transactional
public class IssueServiceImpl implements IssueService {
	
	@Autowired
	private IssueDao issuesDao;

	public void createIssue(Issue issue) {
		issuesDao.create(issue);		
	}

	public void deleteIssue(Issue issue) {
		issuesDao.delete(issue);		
	}

	public void updateIssue(Issue issue) {
		issuesDao.update(issue);		
	}

	public List<Issue> getAllIssue() {
		return issuesDao.getAll();
	}

	public Issue getIssueById(int id) {
		return issuesDao.get(id);
	}

	public List<Issue> getIssueByCreatedUserId(Integer userId) {
		return issuesDao.getIssueByCreatedUserId(userId);
	}

}
