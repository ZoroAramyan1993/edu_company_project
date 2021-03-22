package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    Boolean existByEmail(String email);

    User findByEmail(String email);

    User findById(Long id);
}
