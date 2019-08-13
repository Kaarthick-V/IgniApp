package com.mbhit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhit.dao.ILoginDAO;
import com.mbhit.entity.User;
@Service
public class LoginService implements ILoginService {
	@Autowired
	private ILoginDAO loginDAO;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		 if (loginDAO.userExists(user.getQid(), user.getUserId())) {
	    	   return false;
	       } else {
	    	   loginDAO.adduser(user);
	    	   return true;
	       }
	}
	@Override
	public User CheckUser(String userName, String password) {
		return loginDAO.checkUser(userName,password);
}

}
