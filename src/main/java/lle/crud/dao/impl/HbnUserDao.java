package lle.crud.dao.impl;

import org.springframework.stereotype.Repository;

import lle.crud.dao.UserDao;
import lle.crud.model.User;

@Repository
public class HbnUserDao extends AbstractHbnDao<User> implements UserDao {

	public User getUserByName(String name) {
		User user = null;
		
		user = (User)getSession()
				.createQuery("from User where name = :name")						
				.setParameter("name", name)
				.uniqueResult();
		return user;

	}

}
