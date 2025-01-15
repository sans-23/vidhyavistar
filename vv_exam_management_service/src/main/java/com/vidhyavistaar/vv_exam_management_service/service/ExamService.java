package com.vidhyavistaar.vv_exam_management_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_exam_management_service.entity.Exam;
import com.vidhyavistaar.vv_exam_management_service.repository.ExamRepository;

@Service
public class ExamService {

    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository){
        this.examRepository = examRepository;
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam updateExam(Long id, Exam exam) {
        if (examRepository.existsById(id)) {
            exam.setId(id);
            return examRepository.save(exam);
        }
        return null; // or throw custom exception
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
