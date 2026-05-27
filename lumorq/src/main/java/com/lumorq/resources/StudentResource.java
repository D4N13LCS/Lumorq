package com.lumorq.resources;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.lumorq.entities.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lumorq.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentResource implements Serializable{
    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}