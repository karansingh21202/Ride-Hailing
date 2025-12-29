package com.ridehailing.service;

import com.ridehailing.model.User;
import com.ridehailing.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    // Register new user
    public boolean registerUser(User user) {
        try {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new IllegalArgumentException("Email already registered");
            }
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user
    public boolean updateUser(User user) {
        try {
            userRepository.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete user by ID
    public boolean deleteUser(Long userId) {
        try {
            User user = userRepository.findById(userId);
            if (user != null) {
                userRepository.delete(userId);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
