package com.example.studentservice.serviceImpl;

import com.example.studentservice.entities.Student;
import com.example.studentservice.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
