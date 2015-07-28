package com.msayem.service;

import java.util.List;
import com.msayem.entity.User;

/**
 * Interface for User service implementation.
 * 
 * @author MSAYEM
 * 
 */
public interface UserService {

	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Integer id);
	
	public User getUserById(int id);
	
	public User getUserByName(String name);
	
	public List<User> listUser();
}