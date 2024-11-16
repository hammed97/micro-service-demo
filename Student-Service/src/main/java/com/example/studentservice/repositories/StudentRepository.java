package com.example.studentservice.repositories;

import com.example.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllBySchoolId(Long schoolId);
}
