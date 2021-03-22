package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value = "SELECT * FROM roles r WHERE r.name=:roleName", nativeQuery = true)
  Optional<Role> findByRoleName(String roleName);



}

