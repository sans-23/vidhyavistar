package com.vidhyavistaar.vv_school_management_service.controller;

import com.vidhyavistaar.vv_school_management_service.entity.School;
import com.vidhyavistaar.vv_school_management_service.service.SchoolService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    // Get all Schools
    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return ResponseEntity.ok(schools);
    }

    // Get a specific School by ID
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        return ResponseEntity.ok(school);
    }

    // Create a new School
    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School createdSchool = schoolService.createSchool(school);
        return ResponseEntity.ok(createdSchool);
    }

    // Update an existing School by ID
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School updatedSchool) {
        School school = schoolService.updateSchool(id, updatedSchool);
        return ResponseEntity.ok(school);
    }

    // Delete a School by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.ok("School with ID " + id + " has been deleted.");
    }
}