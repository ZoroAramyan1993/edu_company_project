package com.example.demo.requestresponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    @NotNull
    private String name;


    private String email;

    private String password;
    
}
