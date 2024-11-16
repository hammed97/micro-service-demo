package com.example.studentservice.controller;

import com.example.studentservice.entities.Student;
import com.example.studentservice.serviceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable Long schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
