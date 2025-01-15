package com.vidhyavistaar.vv_school_management_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long userId; // References user in the Auth service.

    @Column(nullable = false, length = 100)
    private String name; // Student's name

    @Column(nullable = true, length = 255)
    private String email; // Student's email (optional)

    @Column(nullable = true, length = 15)
    private String phone; // Student's phone number (optional)

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity; // Reference to the class the student belongs to.

    @Column(nullable = true)
    private LocalDateTime dateOfBirth; // Student's date of birth (optional)

    @Column(nullable = true, length = 50)
    private String rollNumber; // Roll number for the student in their class.

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}