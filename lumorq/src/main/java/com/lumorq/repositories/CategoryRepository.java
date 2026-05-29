package com.lumorq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumorq.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
