package com.example.demo.service;

import com.example.demo.entity.Applicant;

import java.io.FileNotFoundException;
import java.util.List;


public interface ApplicantService {
    Applicant save(Applicant applicant);

    List<Applicant> filterByName(String name);

    Applicant filterByEmail(String email);

    List<Applicant> filterByCourse(String course);

    Applicant update(Applicant applicant);

    void delete(String email);
    List<Applicant> filterByStatus(String status);

    void pdfExporter(String status) throws FileNotFoundException;

}
