package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.exception.RecourseNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Override
    public Optional<Course> searchByName(String name) {
        Course course = courseRepository.findByName(name);
        return Optional.of(course);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course delete(String name) {
        Course course = searchByName(name).orElseThrow(() ->
                new RecourseNotFoundException("not found"));
        courseRepository.delete(course);
        return course;
    }
}
