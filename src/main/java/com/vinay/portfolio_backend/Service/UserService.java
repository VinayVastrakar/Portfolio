package com.vinay.portfolio_backend.Service;

import com.vinay.portfolio_backend.Exception.ResourceNotFoundException;
import com.vinay.portfolio_backend.Models.Users;
import com.vinay.portfolio_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    public Users createUser(Users user) {
        // You can add any additional logic before saving the user
        return userRepository.save(user);
    }

    public Users updateUser(Long userId, Users userDetails) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // Update user fields with userDetails

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);
    }
}
