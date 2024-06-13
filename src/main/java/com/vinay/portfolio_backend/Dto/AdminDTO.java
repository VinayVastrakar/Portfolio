package com.vinay.portfolio_backend.Dto;

import com.vinay.portfolio_backend.Models.Admin;
import lombok.Data;

@Data
public class AdminDTO {
    private String username;
    private String password;

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        return admin;
    }
}
