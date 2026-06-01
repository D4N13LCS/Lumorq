package com.lumorq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumorq.entities.Student;
import com.lumorq.repositories.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Student findById(Long id){
        Optional<Student> obj = repository.findById(id);
        return obj.get();
    }

    public Student insert(Student obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Student update(Long id, Student obj){
        Student entity = repository.getReferenceById(id);
        updateDataStudent(entity, obj);
        return repository.save(entity);
    }

    private void updateDataStudent(Student entity, Student obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
