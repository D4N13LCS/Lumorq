package com.lumorq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumorq.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
