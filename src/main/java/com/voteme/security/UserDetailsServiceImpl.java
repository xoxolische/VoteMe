package com.voteme.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.voteme.dao.UserDao;
import com.voteme.model.UserAuth;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserAuth userAuth = userDao.getUserAuth(login);
		//userAuth.setPassword(new BCryptPasswordEncoder().encode(userAuth.getPassword()));
		if (userAuth == null || userAuth.getUsername() == null || userAuth.getPassword() == null) {
			//System.out.println(userAuth.getPassword());
			throw new UsernameNotFoundException("No user with login " + login);
		}
		return userAuth;
	}

}
