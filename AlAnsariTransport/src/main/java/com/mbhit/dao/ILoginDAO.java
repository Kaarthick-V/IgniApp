/**
 * 
 */
package com.mbhit.dao;

import com.mbhit.entity.User;

/**
 * @author HizSoftware
 *
 */
public interface ILoginDAO {

	boolean userExists(String qid, int userId);

	void adduser(User user);

	User checkUser(String userName, String password);

}
