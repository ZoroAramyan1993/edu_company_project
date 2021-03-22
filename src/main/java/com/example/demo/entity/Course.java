package com.example.demo.entity;



import com.example.demo.chronology.CreateChronology;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String courseName;

    @NotBlank
    private String teacherName;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
   Set<Applicant>applicantSet;


    public Course() {

    }



    public Course(String courseName, String teacherName, String description){
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.description = description;
    }


    public Course(@NotBlank String courseName, @NotBlank String teacherName, String description, LocalDate startDate, LocalDate endDate) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
