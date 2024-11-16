package com.example.schoolservice.controller;

import com.example.schoolservice.dto.FullSchoolResponse;
import com.example.schoolservice.entities.School;
import com.example.schoolservice.serviceImpl.SchoolServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolServiceImpl schoolService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable Long schoolId){
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));

    }


}
