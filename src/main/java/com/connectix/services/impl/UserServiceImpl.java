package com.connectix.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectix.helpers.AppConstants;
import com.connectix.entities.User;
import com.connectix.helpers.ResourceNotFoundException;
import com.connectix.services.userService;
import com.connectix.repositories.userRepo;


@Service
public class UserServiceImpl implements userService {
    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public User saveUser(User user) {
        // Validate mandatory fields
        if (user.getEmail() == null || user.getName() == null) {
            throw new IllegalArgumentException("Email and Name cannot be null");
        }
    
        // Generate user id
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
    
        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // set the user role
        user.setRoleList(List.of(AppConstants.ROLE_USER));
        
    
        logger.info("Saving user with email: {}", user.getEmail());
        
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("User not Found"));
        // update karenge user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfPic(user.getProfPic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        // save the user in database
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        userRepo.delete(user2);
    }
    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;
    }
    @Override
    public boolean isUserExistbyEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserbyEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);

    }


}
