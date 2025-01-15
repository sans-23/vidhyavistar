package com.vidhyavistaar.vv_exam_management_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.vidhyavistaar.vv_exam_management_service.entity.Marks;
import com.vidhyavistaar.vv_exam_management_service.service.MarksService;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    private MarksService marksService;

    public MarksController(MarksService marksService){
        this.marksService = marksService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Marks createMarks(@RequestBody Marks marks) {
        return marksService.createMarks(marks);
    }

    @GetMapping("/student/{studentId}")
    public List<Marks> getMarksByStudentId(@PathVariable Long studentId) {
        return marksService.getMarksByStudentId(studentId);
    }

    @GetMapping("/exam/{examId}")
    public List<Marks> getMarksByExamId(@PathVariable Long examId) {
        return marksService.getMarksByExamId(examId);
    }

    @PutMapping("/{id}")
    public Marks updateMarks(@PathVariable Long id, @RequestBody Marks marks) {
        return marksService.updateMarks(id, marks);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
    }
}