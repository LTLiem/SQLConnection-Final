package lle.crud.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import lle.crud.dao.IssueDao;
import lle.crud.model.Issue;

@Repository
public class HbnIssueDao extends AbstractHbnDao<Issue> implements IssueDao {

	@SuppressWarnings("unchecked")
	public List<Issue> getIssueByCreatedUserId(Integer userId) {
		List<Issue> result = new ArrayList<>();
		
		result = getSession()
				.createQuery("from Issue where userCreatedId = :userId")
				.setParameter("userId", userId)
				.list();

		
		return result;
	}
}
