package com.vinay.portfolio_backend.Controller;

import com.vinay.portfolio_backend.Dto.UserDTO;
import com.vinay.portfolio_backend.Mapper.UserMapper;
import com.vinay.portfolio_backend.Models.Users;
import com.vinay.portfolio_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
        Users user = userService.getUserById(userId);
        return ResponseEntity.ok().body(UserMapper.toDTO(user));
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        Users user = userService.createUser(UserMapper.toEntity(userDTO));
        return UserMapper.toDTO(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserDTO userDTO) {
        Users user = userService.updateUser(userId, UserMapper.toEntity(userDTO));
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
