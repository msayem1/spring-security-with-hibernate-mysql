package com.msayem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msayem.dao.RoleDao;
import com.msayem.entity.Role;
import com.msayem.service.RoleService;

/**
 * Role Interface implementation Class.
 * 
 * @author MSAYEM
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Transactional
	public void addRole(Role role) {
		
		roleDao.addRole(role);
	}

	@Transactional
	public void updateRole(Role role) {
	
		roleDao.updateRole(role);
	}
	
	@Transactional
	public void deleteRole(Integer id) {

		roleDao.deleteRole(id);
	}

	@Transactional
	public Role getRoleById(int id) {

		return roleDao.getRoleById(id);
	}

	@Transactional
	public List<Role> listRole() {
	
		return roleDao.listRole();
	}
}