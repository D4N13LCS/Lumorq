package com.lumorq.resources;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumorq.entities.Enrollment;
import com.lumorq.services.EnrollmentService;

@RestController
@RequestMapping("/Enrollments")
public class EnrollmentResource implements Serializable{
    @Autowired
    private EnrollmentService service;

    @GetMapping
    public ResponseEntity<List<Enrollment>> findAll(){
        List<Enrollment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Enrollment> findById(@PathVariable Long id){
        Enrollment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}