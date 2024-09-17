package com.connectix.services;

import java.util.List;
import java.util.Optional;
import com.connectix.entities.User;
public interface userService {

        User saveUser(User user);
        Optional<User> getUserById(String id);
        Optional<User> updateUser(User user);
        void deleteUser(String id);
        boolean isUserExist(String userId);
        boolean isUserExistbyEmail(String email);
        List<User> getAllUsers();

        
}
