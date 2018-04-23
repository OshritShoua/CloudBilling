package com.cloudbilling.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudbilling.backend.entity.security.UserRole;

public interface UserRoleRepository extends MongoRepository<UserRole, String> {

}
