package com.lumorq.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lumorq.entities.Category;
import com.lumorq.entities.Enrollment;
import com.lumorq.entities.Student;
import com.lumorq.entities.enums.EnrollmentStatus;
import com.lumorq.repositories.CategoryRepository;
import com.lumorq.repositories.EnrollmentRepository;
import com.lumorq.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Backend");
        Category cat2 = new Category(null, "Frontend");
        Category cat3 = new Category(null, "DevOps"); 


        Student s1 = new Student(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Student s2 = new Student(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Enrollment e1 = new Enrollment(null, Instant.parse("2019-06-20T19:53:07Z"), EnrollmentStatus.ACTIVE,s1);
        Enrollment e2 = new Enrollment(null, Instant.parse("2019-07-21T03:42:10Z"), EnrollmentStatus.PENDING,s2);
        Enrollment e3 = new Enrollment(null, Instant.parse("2019-07-22T15:21:22Z"), EnrollmentStatus.PENDING,s1);

        studentRepository.saveAll(Arrays.asList(s1, s2));
        enrollmentRepository.saveAll(Arrays.asList(e1,e2, e3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
    
}
