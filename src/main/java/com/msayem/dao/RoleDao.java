package com.msayem.dao;

import java.util.List;
import com.msayem.entity.Role;

/**
 * Interface for Role DAO implementation.
 * 
 * @author MSAYEM
 * 
 */
public interface RoleDao {

	public void addRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(Integer id);

	public Role getRoleById(Integer id);

	public Role getRoleByName(String roleName);

	public List<Role> listRole();
}