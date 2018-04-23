package com.cloudbilling.backend.service;

import com.cloudbilling.backend.Exceptions.UserCreationException;
import com.cloudbilling.backend.entity.User;
import com.cloudbilling.backend.entity.security.UserRole;
import com.cloudbilling.backend.repository.RoleRepository;
import com.cloudbilling.backend.repository.UserRepository;
import com.cloudbilling.backend.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //transaction to db - if something goes wrong - won't do nothing
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) throws UserCreationException {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
            throw new UserCreationException(String.format("User with username %s already exist.", user.getUsername()));
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            localUser = userRepository.save(user);

            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
                ur.setUser(localUser);
                userRoleRepository.save(ur);
            }

            user.getUserRoles().addAll(userRoles);

            localUser = userRepository.save(user);
        }

        return localUser;
    }
}
