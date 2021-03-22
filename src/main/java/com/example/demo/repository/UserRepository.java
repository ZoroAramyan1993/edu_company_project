package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM users u WHERE u.email=:email",nativeQuery = true)
    Boolean existByEmail(@PathParam("email") String email);

    @Query(value = "SELECT * FROM users u WHERE u.email=:email",nativeQuery = true)
    Optional<User>findByEmail(@PathParam("email") String email);


    @Query(value = "SELECT * FROM users u WHERE u.role=:role",nativeQuery = true)
    Optional<User> findByRole(Role role);
}
