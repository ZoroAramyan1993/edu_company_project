package com.example.demo.service.impl;

import com.example.demo.entity.Applicant;
import com.example.demo.exception.RecourseNotFoundException;
import com.example.demo.pdfgenerator.PdfExporter;
import com.example.demo.repository.ApplicantRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.ApplicantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.FileNotFoundException;
import java.util.List;


@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    CourseRepository courseRepository;


    Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    @Override
    public Applicant save(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public List<Applicant> filterByName(String name) {
        return applicantRepository.findApplicantByName(name);
    }

    @Override
    public Applicant filterByEmail(String email) {
        return applicantRepository.findApplicantByEmail(email).
                orElseThrow(() -> new RecourseNotFoundException(" "));
    }

    @Override
    public List<Applicant> filterByCourse(String course) {
        Long id = courseRepository.findByName(course).getId();
        return applicantRepository.findApplicantByCourse(id).orElseThrow(() -> new RestClientException(" "));
    }

    @Override
    public Applicant update(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public void delete(String email) {
        applicantRepository.findApplicantByEmail(email).ifPresent(applicant -> applicantRepository.delete(applicant));
    }

    @Override
    public List<Applicant> filterByStatus(String status) {
        return applicantRepository.findApplicantByStatus(status);
    }

    @Override
    public void pdfExporter(String status) throws FileNotFoundException {
        PdfExporter pdfExporter = new PdfExporter();
        List<Applicant> applicants= filterByStatus(status);
         pdfExporter.insertPdf(applicants);
    }
}
