package com.dipen.ods.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dipen.ods.entities.Role;
import com.dipen.ods.entities.User;
import com.dipen.ods.entities.UserRole;
import com.dipen.ods.models.UserType;
import com.dipen.ods.repositories.UserRepository;
import com.dipen.ods.services.RoleService;
import com.dipen.ods.services.UserService;

@Component
public class CustomStartupTaskExecutor {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void createDefaultAdmin() throws IOException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		User userAdmin = userRepository.findByEmail("admin@gmail.com");
		if (userAdmin == null) {
			System.out.println("Inside default  admin user creation");
			User admin = new User("admin@gmail.com", passwordEncoder.encode("password"), "ADMIN", "ADMIN",UserType.ADMIN);
			Role role = roleService.findOrCreateRole("ROLE_ADMIN");
			Set<UserRole> userRole = new HashSet<UserRole>();
			userRole.add(new UserRole(admin, role));
			userService.createUser(admin, userRole);
			System.out.println("Default user of admin type is created");
		}

		User userUser = userRepository.findByEmail("user@gmail.com");

		if (userUser == null) {

			System.out.println("Inside default  user type user creation");
			User user = new User("user@gmail.com", passwordEncoder.encode("password"), "USER", "USER", UserType.USER);
			Role roles = roleService.findOrCreateRole("ROLE_USER");
			Set<UserRole> userRoles = new HashSet<UserRole>();
			userRoles.add(new UserRole(user, roles));
			userService.createUser(user, userRoles);
			System.out.println("Default user of user type is created");
		}
		
		User userOne = userRepository.findByEmail("userone@gmail.com");

		if (userOne == null) {

			System.out.println("Inside default  user type user creation");
			User user = new User("userone@gmail.com", passwordEncoder.encode("password"), "USER", "USER", UserType.USER);
			Role roles = roleService.findOrCreateRole("ROLE_USER");
			Set<UserRole> userRoles = new HashSet<UserRole>();
			userRoles.add(new UserRole(user, roles));
			userService.createUser(user, userRoles);
			System.out.println("Default user of user type is created");
		}

	}
}
