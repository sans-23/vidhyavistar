package com.vidhyavistaar.vv_exam_management_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.vidhyavistaar.vv_exam_management_service.entity.Exam;
import com.vidhyavistaar.vv_exam_management_service.service.ExamService;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private ExamService examService;

    public ExamController(ExamService examService){
        this.examService = examService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    // Get all Exams
    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    // Get Exam by ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    // Update Exam
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        return examService.updateExam(id, exam);
    }

    // Delete Exam
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
