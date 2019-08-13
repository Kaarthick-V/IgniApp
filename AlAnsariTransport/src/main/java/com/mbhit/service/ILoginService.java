/**
 * 
 */
package com.mbhit.service;

import com.mbhit.entity.User;

/**
 * @author HizSoftware
 *
 */
public interface ILoginService {

	boolean addUser(User user);

	User CheckUser(String userName, String password);

}
