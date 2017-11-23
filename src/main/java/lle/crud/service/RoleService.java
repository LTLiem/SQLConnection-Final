package lle.crud.service;

import java.util.List;

import lle.crud.model.Role;

public interface RoleService {
	
	public void createRole(Role role);
	
	public void deleteRole(Role role);
	
	public void updateRole(Role role);
	
	public List<Role> getAllRole(); 
	
	
}
