package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecourseNotFoundException extends RuntimeException {
private String resourceName;
private String fieldName;
private String fieldValue;


public RecourseNotFoundException(String message){
   super(message);
}

public RecourseNotFoundException(String resourceName,String fieldName,String fieldValue){
 super(String.format("recourse not found",resourceName,fieldName,fieldValue));
}

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
