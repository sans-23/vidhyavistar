package com.vidhyavistaar.vv_exam_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vidhyavistaar.vv_exam_management_service.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    
}
