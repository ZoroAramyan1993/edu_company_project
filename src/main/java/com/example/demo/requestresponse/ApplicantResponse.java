package com.example.demo.requestresponse;

import com.example.demo.entity.Course;
import com.example.demo.enums.Status;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ApplicantResponse {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private Status status;

   private Course course;

}
