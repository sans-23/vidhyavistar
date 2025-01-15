package com.vidhyavistaar.vv_school_management_service.service;

import com.vidhyavistaar.vv_school_management_service.entity.SchoolAdmin;
import com.vidhyavistaar.vv_school_management_service.repository.SchoolAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolAdminService {

    private final SchoolAdminRepository schoolAdminRepository;

    public SchoolAdminService(SchoolAdminRepository schoolAdminRepository) {
        this.schoolAdminRepository = schoolAdminRepository;
    }

    public SchoolAdmin createSchoolAdmin(SchoolAdmin schoolAdmin) {
        return schoolAdminRepository.save(schoolAdmin);
    }

    public SchoolAdmin getSchoolAdminById(Long id) {
        return schoolAdminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SchoolAdmin not found with ID: " + id));
    }

    public List<SchoolAdmin> getAllSchoolAdmins() {
        return schoolAdminRepository.findAll();
    }

    public SchoolAdmin updateSchoolAdmin(Long id, SchoolAdmin updatedData) {
        SchoolAdmin existingAdmin = schoolAdminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SchoolAdmin with ID " + id + " not found"));

        existingAdmin.setName(updatedData.getName());
        existingAdmin.setEmail(updatedData.getEmail());
        existingAdmin.setPhone(updatedData.getPhone());
        existingAdmin.setSchool(updatedData.getSchool());

        return schoolAdminRepository.save(existingAdmin);
    }

    public void deleteSchoolAdmin(Long id) {
        if (!schoolAdminRepository.existsById(id)) {
            throw new IllegalArgumentException("SchoolAdmin with ID " + id + " not found");
        }
        schoolAdminRepository.deleteById(id);
    }
}