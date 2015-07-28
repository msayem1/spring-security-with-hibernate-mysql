package com.msayem.dao;

import java.util.List;
import com.msayem.entity.User;

/**
 * Interface for User DAO implementation.
 * 
 * @author MSAYEM
 * 
 */
public interface UserDao {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer id);

	public User getUserById(Integer id);

	public User getUserByName(String name);

	public List<User> listUser();
}