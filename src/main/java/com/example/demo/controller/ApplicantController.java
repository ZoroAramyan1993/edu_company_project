package com.example.demo.controller;

import com.example.demo.requestresponse.ApiResponse;
import com.example.demo.entity.Applicant;
import com.example.demo.entity.Course;
import com.example.demo.enums.Status;
import com.example.demo.service.ApplicantService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/applicant/")
public class ApplicantController {
    @Autowired
    ApplicantService applicantService;
    @Autowired
    CourseService courseService;

    @GetMapping("email/{email}")
    Applicant getEmail(@PathVariable String email) {
        Applicant applicant = applicantService.filterByEmail(email);
        return applicant;
    }

    @GetMapping("getCourse")
    List<Applicant> getByCourse(@RequestParam String course) {
        List<Applicant> applicant = applicantService.filterByCourse(course);
        return applicant;
    }

    @GetMapping("get")
    List<Applicant> getByName(@RequestParam String name) {
        List<Applicant> applicants = applicantService.filterByName(name);
        return applicants;
    }

    @PutMapping("update")
    Applicant update(@Valid @RequestBody Applicant applicantResponse, @RequestParam String email) {
        Applicant applicant = applicantService.filterByEmail(email);
        applicant.setEmail(applicantResponse.getEmail());
        applicant.setName(applicantResponse.getName());
        applicant.setAddress(applicantResponse.getAddress());
        applicantService.save(applicant);
        return applicant;
    }

    @Transactional
    @PostMapping("save")
    ResponseEntity<?> save(@RequestParam String name, @RequestParam String status, @Valid @RequestBody Applicant applicant) {
        Course course = courseService.searchByName(name).get();
        applicant.setCourse(course);
        applicant.setStatus(Status.valueOf(status));
        applicant = applicantService.save(applicant);

        Set<Applicant> applicants = new HashSet<>();
        applicants.addAll(course.getApplicantSet());
        applicants.add(applicant);
        course.getApplicantSet().clear();
        course.getApplicantSet().addAll(applicants);

        URI location  = ServletUriComponentsBuilder.
                fromCurrentContextPath().path("/api/applicant/{name}").
                buildAndExpand(applicant.getName()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true,"Applicant created successfully"));
        //return ResponseEntity.ok(applicant);
    }


    @DeleteMapping("{email}")
    ResponseEntity delete(@PathVariable String email) {
        applicantService.delete(email);
        return ResponseEntity.ok().build();
    }
}
