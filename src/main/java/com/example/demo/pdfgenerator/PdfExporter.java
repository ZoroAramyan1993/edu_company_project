package com.example.demo.pdfgenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Period;
import java.util.List;


import com.example.demo.entity.Applicant;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class PdfExporter {
    public PdfExporter() { }
    public void insertPdf(List<Applicant> listUsers) throws FileNotFoundException {
        for (Applicant applicant:listUsers){
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("certificates/pdf" +applicant.getId() +".pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            Paragraph p = new Paragraph("Certificate", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p);
            Paragraph p1 = new Paragraph(applicant.getCourse().getCourseName());
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p1);
            Paragraph p2 = new Paragraph(applicant.getCourse().getDescription());
            p2.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p2);

            Paragraph p3 = new Paragraph("Applicant name - " + applicant.getName());
            p3.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p3);
            Paragraph p4 = new Paragraph("Teacher name - " + applicant.getCourse().getTeacherName());
            p4.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p4);
            int months  = Period.between(applicant.getCourse().getStartDate().withDayOfMonth(1), applicant.getCourse().getEndDate().withDayOfMonth(1)).getMonths();
//            Paragraph p5 = new Paragraph("Duration - " +String.valueOf(months) + " months");
//            long months = Duration.between(applicant.getCourse().getUpdated(),applicant.getCourse().getCreated()).toDays()/30;
//            Long months = ChronoUnit.MONTHS.between(applicant.getCourse().getEndDate(), applicant.getCourse().getStartDate())/30;
            Paragraph p5 = new Paragraph("Duration - " + String.valueOf(months) + " months");
            p5.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p5);
            document.close();
        }
    }
}
