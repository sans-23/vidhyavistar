package com.vidhyavistaar.vv_school_management_service.controller;

import com.vidhyavistaar.vv_school_management_service.entity.SchoolAdmin;
import com.vidhyavistaar.vv_school_management_service.service.SchoolAdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-admins")
public class SchoolAdminController {

    private final SchoolAdminService schoolAdminService;

    public SchoolAdminController(SchoolAdminService schoolAdminService) {
        this.schoolAdminService = schoolAdminService;
    }

    // Get all SchoolAdmins
    @GetMapping
    public ResponseEntity<List<SchoolAdmin>> getAllSchoolAdmins() {
        List<SchoolAdmin> admins = schoolAdminService.getAllSchoolAdmins();
        return ResponseEntity.ok(admins);
    }

    // Get a specific SchoolAdmin by ID
    @GetMapping("/{id}")
    public ResponseEntity<SchoolAdmin> getSchoolAdminById(@PathVariable Long id) {
        SchoolAdmin admin = schoolAdminService.getSchoolAdminById(id);
        return ResponseEntity.ok(admin);
    }

    // Create a new SchoolAdmin
    @PostMapping
    public ResponseEntity<SchoolAdmin> createSchoolAdmin(@RequestBody SchoolAdmin schoolAdmin) {
        SchoolAdmin createdAdmin = schoolAdminService.createSchoolAdmin(schoolAdmin);
        return ResponseEntity.ok(createdAdmin);
    }

    // Update an existing SchoolAdmin by ID
    @PutMapping("/{id}")
    public ResponseEntity<SchoolAdmin> updateSchoolAdmin(
            @PathVariable Long id, 
            @RequestBody SchoolAdmin updatedSchoolAdmin) {
        SchoolAdmin updatedAdmin = schoolAdminService.updateSchoolAdmin(id, updatedSchoolAdmin);
        return ResponseEntity.ok(updatedAdmin);
    }

    // Delete a SchoolAdmin by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchoolAdmin(@PathVariable Long id) {
        schoolAdminService.deleteSchoolAdmin(id);
        return ResponseEntity.ok("SchoolAdmin with ID " + id + " has been deleted successfully.");
    }
}