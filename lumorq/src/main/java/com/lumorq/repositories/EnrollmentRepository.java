package com.lumorq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumorq.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
    
}
