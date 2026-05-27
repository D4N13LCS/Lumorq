package com.lumorq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumorq.entities.Enrollment;
import com.lumorq.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepository repository;

    public List<Enrollment> findAll(){
        return repository.findAll();
    }

    public Enrollment findById(Long id){
        Optional<Enrollment> obj = repository.findById(id);
        return obj.get();
    }
}
