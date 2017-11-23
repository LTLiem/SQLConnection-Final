package lle.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lle.crud.dao.RoleDao;
import lle.crud.model.Role;
import lle.crud.service.RoleService;

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public void createRole(Role role) {
		roleDao.create(role);
	}

	public void deleteRole(Role role) {
		roleDao.delete(role);
	}

	public void updateRole(Role role) {
		roleDao.update(role);
	}

	public List<Role> getAllRole() {
		return roleDao.getAll();
	}

}
