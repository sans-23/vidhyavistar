package com.vidhyavistaar.vv_exam_management_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_exam_management_service.entity.Marks;
import com.vidhyavistaar.vv_exam_management_service.repository.MarksRepository;

@Service
public class MarksService {
    private MarksRepository marksRepository;

    public MarksService(MarksRepository marksRepository){
        this.marksRepository = marksRepository;
    } 

    public Marks createMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public Marks getMarksById(Long id) {
        return marksRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Marks not found with id: " + id));
    }

    public List<Marks> getMarksByStudentId(Long studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    public List<Marks> getMarksByExamId(Long examId) {
        return marksRepository.findByExamId(examId);
    }

    public Marks updateMarks(Long id, Marks marks) {
        if (marksRepository.existsById(id)) {
            marks.setId(id);
            return marksRepository.save(marks);
        }
        return null; // or throw custom exception
    }

    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}
