package com.example.demo.service;



import com.example.demo.entity.Course;


import java.util.Optional;

public interface CourseService {
    Optional<Course> searchByName(String name);

    Course save(Course course);

    Course update(Course course);

    Course delete(String name);
}










