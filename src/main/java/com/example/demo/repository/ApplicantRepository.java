package com.example.demo.repository;

import com.example.demo.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    @Query(value = "SELECT * FROM Applicant a WHERE a.name=:name",nativeQuery = true)
    List<Applicant> findApplicantByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Applicant a WHERE a.status=:name",nativeQuery = true)
    List<Applicant> findApplicantByStatus(@Param("name") String name);

    @Query(value = "SELECT * FROM Applicant a WHERE a.email=:email",nativeQuery = true)
    Optional<Applicant> findApplicantByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM Applicant a WHERE a.course_id=:courseId",nativeQuery = true)
   Optional<List<Applicant>> findApplicantByCourse(@Param("courseId") Long courseId);

    @Query(value = "SELECT * FROM Applicant a WHERE a.email=:email",nativeQuery = true)
    Boolean existByEmail(@Param(("email")) String email);
}
