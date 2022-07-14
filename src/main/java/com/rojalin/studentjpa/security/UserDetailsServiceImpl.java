package com.rojalin.studentjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rojalin.studentjpa.model.User;
import com.rojalin.studentjpa.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.getUserByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not find any user");
		}
		
		return  new MyUserDetails(user);
	}

}
