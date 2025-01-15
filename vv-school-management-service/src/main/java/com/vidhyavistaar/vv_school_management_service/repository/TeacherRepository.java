package com.vidhyavistaar.vv_school_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidhyavistaar.vv_school_management_service.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}