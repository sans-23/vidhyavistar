package com.vidhyavistaar.vv_school_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vidhyavistaar.vv_school_management_service.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    // Custom queries (if needed) can be added here
}