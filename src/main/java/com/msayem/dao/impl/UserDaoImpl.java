package com.msayem.dao.impl;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.msayem.entity.User;
import com.msayem.entity.Role;
import com.msayem.dao.UserDao;
import com.msayem.dao.RoleDao;

/**
 * User DAO implementation Class.
 * 
 * @author MSAYEM
 * 
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private RoleDao roleDao;

	@Override
	public void addUser(User user) {
		
		user.setEnabled(true);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleDao.getRoleByName("ROLE_USER"));
		user.setRole(roles);

		sessionFactory.getCurrentSession().save(user);
	}
  	
	@Override
	public List<User> listUser() {

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
			.createCriteria(User.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(Integer userId) {

		Session session = sessionFactory.getCurrentSession();

		List<User> listUser = session.createQuery("from Users user where user.id = :userId")
			.setParameter("userId", userId)
			.list();
    	
		return listUser.size() > 0 ?(User) listUser.get(0): null;
	}
	
	@Override
	public void updateUser(User user) {
		
		sessionFactory.getCurrentSession().update(user);
	}
		
	@Override
	public void deleteUser(Integer id) {

		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		
		if (null != user) {
			
			sessionFactory.getCurrentSession().delete(user);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getUserByName(String userName) {

		Session session = sessionFactory.getCurrentSession();

		List<User> listUser = session.createQuery("from Users user where user.name = :userName")
			.setParameter("userName", userName)
			.list();

		return listUser.size() > 0 ?(User) listUser.get(0): null;
	}
}