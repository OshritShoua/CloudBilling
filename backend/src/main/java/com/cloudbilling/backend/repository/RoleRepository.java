package com.cloudbilling.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudbilling.backend.entity.security.Role;


public interface RoleRepository extends MongoRepository<Role, String>{

}
