package lle.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lle.crud.dao.UserDao;
import lle.crud.model.User;
import lle.crud.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void createUser(User user) {
		userDao.create(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public List<User> getAllUser() {
		return userDao.getAll();
	}

	public User getUserById(int id) {		
		return userDao.get(id);
	}

	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

}
