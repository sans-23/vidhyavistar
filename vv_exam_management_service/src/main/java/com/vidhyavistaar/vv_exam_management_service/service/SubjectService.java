package com.vidhyavistaar.vv_exam_management_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_exam_management_service.entity.Subject;
import com.vidhyavistaar.vv_exam_management_service.repository.SubjectRepository;

@Service
public class SubjectService {
    
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject updateSubject(Long id, Subject subject) {
        if (subjectRepository.existsById(id)) {
            subject.setId(id);
            return subjectRepository.save(subject);
        }
        return null; // or throw custom exception
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
