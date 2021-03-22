package com.example.demo.entity;


import com.example.demo.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Basic
    @NaturalId
    @Email(message = "email can not be null")
    private String email;
    private String phoneNumber;


    private String address;

    @Enumerated(EnumType.STRING)
    private Status status;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    public Applicant() {

    }

    public Applicant(@NotNull String name,
                     @Email String email, String phoneNumber, String address, Status status, Course course) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.course = course;
    }

    public Applicant(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
