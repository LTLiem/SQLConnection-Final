package lle.crud.dao;

import lle.crud.model.User;

public interface UserDao extends Dao<User> {

	public User getUserByName(String name);
	
}
