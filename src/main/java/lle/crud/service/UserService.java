package lle.crud.service;

import java.util.List;

import lle.crud.model.User;


public interface UserService {
	
	public void createUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getAllUser(); 
	
	public User getUserById(int id);
	
	public User getUserByName(String name);
	
}
