package com.example.ProjectTest.repository;

import com.example.ProjectTest.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperJPARepository extends JpaRepository<Developer, Long> {
}
