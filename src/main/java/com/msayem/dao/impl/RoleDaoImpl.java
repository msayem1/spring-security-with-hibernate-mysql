package com.msayem.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.msayem.entity.Role;
import com.msayem.dao.RoleDao;

/**
 * Role DAO implementation class.
 * 
 * @author MSAYEM
 * 
 */
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRole(Role role) {

		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public List<Role> listRole() {

		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) sessionFactory.getCurrentSession()
			.createCriteria(Role.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listRole;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Role getRoleById(Integer roleId) {
		
		Session session = sessionFactory.getCurrentSession();

		List<Role> listRole = session.createQuery("from Roles role where role.id = :roleId")
			.setParameter("roleId", roleId)
			.list();

		return listRole.size() > 0 ?(Role) listRole.get(0): null;
	}

	@Override
	public void updateRole(Role role) {
		
		sessionFactory.getCurrentSession().update(role);
	}

	@Override
	public void deleteRole(Integer id) {

		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);

		if (null != role) {

			sessionFactory.getCurrentSession().delete(role);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Role getRoleByName(String roleName) {

		Session session = sessionFactory.getCurrentSession();

		List<Role> listRole = session.createQuery("from Roles role where role.name = :roleName")
			.setParameter("roleName", roleName)
			.list();

		return listRole.size() > 0 ?(Role) listRole.get(0): null;
	}
}