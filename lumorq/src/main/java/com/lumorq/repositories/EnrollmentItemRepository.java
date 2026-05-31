package com.lumorq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lumorq.entities.EnrollmentItem;
import com.lumorq.entities.pk.EnrollmentItemPk;

public interface EnrollmentItemRepository extends JpaRepository<EnrollmentItem, EnrollmentItemPk>{
    
}
