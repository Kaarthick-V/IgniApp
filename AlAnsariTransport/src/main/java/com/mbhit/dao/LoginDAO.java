package com.mbhit.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mbhit.entity.User;


@Transactional
@Repository
public class LoginDAO implements ILoginDAO{
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public boolean userExists(String qid, int userId) {
		// TODO Auto-generated method stub
		String hql = "FROM User as U WHERE U.qid = ? and U.UserId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, qid)
		              .setParameter(2, userId).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void adduser(User user) {
		entityManager.persist(user);

	}

	@Override
	public User checkUser(String userName, String password) {
User Loggeduser=new User();
		String hql = "FROM User as U WHERE U.qid = ?1 and U.password = ?2";
		@SuppressWarnings("unchecked")
		List<User> result = entityManager.createQuery(hql).setParameter(1, userName)
		              .setParameter(2, password).getResultList();
		if(!result.isEmpty()) {
			Loggeduser=result.get(0);
		}else {
			Loggeduser=null;
		}
	return Loggeduser;
	}

}
