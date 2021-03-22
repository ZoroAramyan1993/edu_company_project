package com.example.demo.controller;

import com.example.demo.entity.Applicant;
import com.example.demo.enums.Status;
import com.example.demo.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pdf")
public class DownloadPdfController {

    @Autowired
    ApplicantService applicantService;


    @GetMapping(produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadPdf(@RequestParam String email) throws IOException {
        Applicant applicant = applicantService.filterByEmail(email);
        if (applicant!=null && applicant.getStatus()==Status.COMPLETED) {
            applicantService.pdfExporter(String.valueOf(Status.COMPLETED));
            ClassPathResource pdfFile = new ClassPathResource("certificates/pdf" +applicant.getId()+".pdf", getClass());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control","no-cache,no-store,must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires","0");
            return ResponseEntity.ok().headers(headers).contentLength(pdfFile.contentLength()).
                    contentType(MediaType.parseMediaType("application/octet-stream")).
                    body(new InputStreamResource(pdfFile.getInputStream()));
        }else {
            return ResponseEntity.notFound().build();
        }
}
}
