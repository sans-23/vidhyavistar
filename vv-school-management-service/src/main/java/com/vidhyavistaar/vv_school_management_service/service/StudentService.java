package com.vidhyavistaar.vv_school_management_service.service;

import org.springframework.stereotype.Service;

import com.vidhyavistaar.vv_school_management_service.entity.Student;
import com.vidhyavistaar.vv_school_management_service.repository.StudentRepositoy;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepositoy studentRepositoy;

    public StudentService(StudentRepositoy studentRepositoy) {
        this.studentRepositoy = studentRepositoy;
    }

    // Create or Save a Student
    public Student saveStudent(Student student) {
        return studentRepositoy.save(student);
    }

    // Get all Students
    public List<Student> getAllStudents() {
        return studentRepositoy.findAll();
    }

    // Get Student by ID
    public Student getStudentById(Long id) {
        return studentRepositoy.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found."));
    }

    // Update Student
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepositoy.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setPhone(studentDetails.getPhone());
            student.setClassEntity(studentDetails.getClassEntity());
            return studentRepositoy.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Delete Student
    public void deleteStudent(Long id) {
        studentRepositoy.deleteById(id);
    }
}