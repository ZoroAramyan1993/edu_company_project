package com.example.demo.controller;


import com.example.demo.requestresponse.CourseResponse;
import com.example.demo.entity.Course;
import com.example.demo.exception.RecourseNotFoundException;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/course")
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/{name}")
    ResponseEntity<Course> getByName(@PathVariable String name) {
        Course course = courseService.searchByName(name).get();
        return ResponseEntity.ok(course);
    }

    @PostMapping("/save")
    ResponseEntity<?> save( @Valid @RequestBody Course courseResponse) {
        Course course = new Course(courseResponse.getCourseName(),
                courseResponse.getDescription(),
               courseResponse.getTeacherName(),courseResponse.getStartDate(),courseResponse.getEndDate());
         courseService.save(course);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{name}/update")
    ResponseEntity<?> update(@Valid @RequestBody CourseResponse courseResponse, @PathVariable String name) {
        Course course = courseService.searchByName(name).map(course1 -> {
            course1.setCourseName(courseResponse.getCourseName());
            course1.setTeacherName(courseResponse.getTeacherName());
            course1.setDescription(courseResponse.getDescription());
            return courseService.update(course1);
        }).orElseThrow(() -> new RecourseNotFoundException(""));
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{name}/delete")
    ResponseEntity delete(@PathVariable String name) {
        Course course = courseService.delete(name);
        return ResponseEntity.ok(course);
    }
}
