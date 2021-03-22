package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.RecourseNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;



    @Override
    public Boolean existByEmail(String email) {
       return userRepository.existByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->
                new RecourseNotFoundException("email not found" + email));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RecourseNotFoundException("id not found" + id));
    }

}
