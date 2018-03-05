package com.voteme.utils;

import org.springframework.security.core.Authentication;

import com.voteme.model.UserAuth;

public class CurrentUser {
	
	private CurrentUser() {
		
	}
	
	public static boolean isCurrentUser(long id, Authentication auth) {
		if(auth != null) {
			UserAuth u = (UserAuth) auth.getPrincipal();
			if (id == u.getId())
				return true;
		}
		return false;
	}
	
	public static boolean isAdmin(Authentication auth) {
		if(auth != null) {
			UserAuth u = (UserAuth) auth.getPrincipal();
			if(u.getRole().getName().equalsIgnoreCase("admin")) {
				return true;				
			}else {
				return false;
			}
		}
		return false;
	}

}
