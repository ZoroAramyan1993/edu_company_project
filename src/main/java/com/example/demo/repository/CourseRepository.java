package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query(value = "SELECT  * FROM course c WHERE c.course_name=:name",nativeQuery = true)
    Course findByName(@PathParam("name") String name);

    @Query(value = "SELECT * FROM course c WHERE c.course_name=:name",nativeQuery = true)
    Boolean existByNAme(@Param(("name")) String name);
}
