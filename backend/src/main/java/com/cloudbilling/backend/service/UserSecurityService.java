package com.cloudbilling.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloudbilling.backend.entity.User;
import com.cloudbilling.backend.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if(user == null) {
			LOG.warn("Username not found");
			throw new UsernameNotFoundException ("Username " + username + "not found");
		}

		return user;
	}

}
