package com.dipen.ods.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dipen.ods.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
