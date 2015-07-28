package com.msayem.service;

import java.util.List;
import com.msayem.entity.Role;

/**
 * Interface for Role service implementation.
 * 
 * @author MSAYEM
 * 
 */
public interface RoleService {

	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public void deleteRole(Integer id);
	
	public Role getRoleById(int id);
	
	public List<Role> listRole();
}