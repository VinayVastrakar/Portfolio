package com.vinay.portfolio_backend.Service;

import com.vinay.portfolio_backend.Models.Admin;
import com.vinay.portfolio_backend.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;



    public boolean existsByUsername(String username) {
        return adminRepository.existsByUsername(username);
    }

    public Admin saveAdmin(Admin admin) {
        admin.setPassword(PasswordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
