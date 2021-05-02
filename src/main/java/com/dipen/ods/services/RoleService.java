package com.dipen.ods.services;

import com.dipen.ods.entities.Role;

public interface RoleService {

	Role findOrCreateRole(String name);

}
