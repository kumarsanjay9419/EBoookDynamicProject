package com.sk.DAO;

import com.sk.entities.User;

public interface UserDAO {
	
	boolean userRegistration(User user);
	User userLogin(String email,String password);

}
