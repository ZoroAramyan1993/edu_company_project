package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    UserService applicantService;
    @GetMapping("email/{email}")
    ResponseEntity<User> getEmail(@PathVariable String email) {
        User applicant = applicantService.findByEmail(email);
        return ResponseEntity.ok(applicant);
    }
}
