/**
 * 
 */
package org.gotprint.assignment.usernotesmanagement.service.impl;

import java.util.Arrays;

import org.gotprint.assignment.usernotesmanagement.jpa.entity.User;
import org.gotprint.assignment.usernotesmanagement.jpa.repository.UserRepository;
import org.gotprint.assignment.usernotesmanagement.service_api.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * It is a User Service implementation for the userService. 
 * 
 * @author sudhanshusharma
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				Arrays.asList(authority));
		return userDetails;
	}
}
