package com.example.demo.requestresponse;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ApiResponse {
    private Boolean success;
    private String message;
    public ApiResponse(Boolean success, String message){
        this.success = success;
        this.message = message;
    }

}
