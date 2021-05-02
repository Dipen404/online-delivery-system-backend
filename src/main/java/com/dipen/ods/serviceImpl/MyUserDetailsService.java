package com.dipen.ods.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dipen.ods.entities.User;
import com.dipen.ods.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(s);
	        if (user == null)
	            throw new UsernameNotFoundException("User doesn't exists");

	        return user;
	    }

}