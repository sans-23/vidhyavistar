package com.vidhyavistaar.vv_exam_management_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student is in a different microservice, so we store only the studentId (foreign key)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    // Exam is in the current service, so it's still a direct reference
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @Column(nullable = false)
    private Double score;

    private String grade;
}
