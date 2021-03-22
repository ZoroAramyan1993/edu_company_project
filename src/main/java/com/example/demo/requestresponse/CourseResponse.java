package com.example.demo.requestresponse;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CourseResponse  {
    @NotNull
    private String courseName;
    @NotNull
    private String teacherName;
    @NotNull
    private String description;

    public String getCourseName() {
        return courseName;
    }
public CourseResponse(){

}

public CourseResponse(String courseName,String teacherName,String description){
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.description = description;
}

}
