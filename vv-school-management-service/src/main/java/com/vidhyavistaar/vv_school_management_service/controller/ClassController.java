package com.vidhyavistaar.vv_school_management_service.controller;

import com.vidhyavistaar.vv_school_management_service.entity.ClassEntity;
import com.vidhyavistaar.vv_school_management_service.service.ClassService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    // Get all Classes
    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        List<ClassEntity> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // Get a specific Class by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
        ClassEntity classEntity = classService.getClassById(id);
        return ResponseEntity.ok(classEntity);
    }

    // Create a new Class
    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@RequestBody ClassEntity classEntity) {
        ClassEntity createdClass = classService.createClass(classEntity);
        return ResponseEntity.ok(createdClass);
    }

    // Update an existing Class by ID
    @PutMapping("/{id}")
    public ResponseEntity<ClassEntity> updateClass(@PathVariable Long id, @RequestBody ClassEntity updatedClassEntity) {
        ClassEntity classEntity = classService.updateClass(id, updatedClassEntity);
        return ResponseEntity.ok(classEntity);
    }

    // Delete a Class by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.ok("Class with ID " + id + " has been deleted.");
    }
}