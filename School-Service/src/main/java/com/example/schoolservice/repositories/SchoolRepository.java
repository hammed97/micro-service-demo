package com.example.schoolservice.repositories;

import com.example.schoolservice.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
