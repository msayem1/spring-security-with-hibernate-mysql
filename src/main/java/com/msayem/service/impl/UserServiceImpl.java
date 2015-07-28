package com.msayem.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msayem.entity.User;
import com.msayem.dao.UserDao;
import com.msayem.service.UserService;

/**
 * User Interface implementation Class.
 * 
 * @author MSAYEM
 * 
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Transactional
	public void addUser(User user) {
		
		userDao.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {

		userDao.updateUser(user);
	}
	
	@Transactional
	public void deleteUser(Integer id) {

		userDao.deleteUser(id);
	}	


	public User getUserById(int id) {

		return userDao.getUserById(id);
    }

	@Transactional
	public User getUserByName(String name) {

		return userDao.getUserByName(name);
	}
	
	@Transactional
	public List<User> listUser() {

		return userDao.listUser();
	}
}