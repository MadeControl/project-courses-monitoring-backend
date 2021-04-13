package com.example.projectcoursesmonitoringbackend.repository;

import com.example.projectcoursesmonitoringbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
