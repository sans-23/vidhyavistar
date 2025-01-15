package com.vidhyavistaar.vv_school_management_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_school_management_service.entity.ClassEntity;
import com.vidhyavistaar.vv_school_management_service.repository.ClassRepository;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ClassEntity createClass(ClassEntity schoolClass) {
        return classRepository.save(schoolClass);
    }

    public List<ClassEntity> getAllClasses(){
        return classRepository.findAll();
    }

    public ClassEntity getClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + id));
    }

    public List<ClassEntity> getClassesBySchoolId(Long schoolId) {
        return classRepository.findBySchoolId(schoolId);
    }

    public ClassEntity updateClass(Long id, ClassEntity schoolClass) {
        ClassEntity existingClass = getClassById(id);
        existingClass.setName(schoolClass.getName());
        return classRepository.save(existingClass);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
