package com.todo;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("vijay") && password.equals("vijay"))
			return true;
		return false;
	}
}
