package com.lumorq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumorq.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
