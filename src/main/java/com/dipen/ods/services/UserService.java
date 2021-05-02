package com.dipen.ods.services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.dipen.ods.entities.User;
import com.dipen.ods.entities.UserRole;
import com.dipen.ods.models.AdminDTO;

public interface UserService {
	
	void createUser(User user, Set<UserRole> userRoles) throws IOException;
	User findUserByUserName(String uname);
	List<AdminDTO> getTotalRecords();

}
