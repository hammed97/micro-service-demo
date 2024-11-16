package com.example.schoolservice.serviceImpl;

import com.example.schoolservice.client.StudentClient;
import com.example.schoolservice.dto.FullSchoolResponse;
import com.example.schoolservice.entities.School;
import com.example.schoolservice.repositories.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl {

    private final SchoolRepository schoolRepository;

    private final StudentClient client;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository, StudentClient client) {
        this.schoolRepository = schoolRepository;
        this.client = client;
    }

    public void saveSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());

        var students = client.findAllStudentsBySchool(schoolId);  // find all the students from the student micro-service
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
