package com.vidhyavistaar.vv_school_management_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_school_management_service.entity.School;
import com.vidhyavistaar.vv_school_management_service.repository.SchoolRepository;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School updateSchool(Long id, School school) {
        School existingSchool = getSchoolById(id);
        existingSchool.setName(school.getName());
        existingSchool.setAddress(school.getAddress());
        return schoolRepository.save(existingSchool);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
