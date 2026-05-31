package com.lumorq.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lumorq.entities.Category;
import com.lumorq.entities.Course;
import com.lumorq.entities.Enrollment;
import com.lumorq.entities.EnrollmentItem;
import com.lumorq.entities.Student;
import com.lumorq.entities.enums.EnrollmentStatus;
import com.lumorq.repositories.CategoryRepository;
import com.lumorq.repositories.CourseRepository;
import com.lumorq.repositories.EnrollmentItemRepository;
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

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentItemRepository EnrollmentItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Backend");
        Category cat2 = new Category(null, "Frontend");
        Category cat3 = new Category(null, "DevOps"); 

        Course c1 = new Course(null, "Java Spring Boot",
        "Complete REST API development with Spring Boot and JPA.",
        90.5, "");

        Course c2 = new Course(null, "React Modern UI",
                "Build modern and responsive interfaces using React.",
                219.0, "");

        Course c3 = new Course(null, "Docker & Kubernetes",
                "Learn containerization and orchestration for scalable applications.",
                125.0, "");

        Course c4 = new Course(null, "Node.js API Mastery",
                "Create scalable backend applications with Node.js and Express.",
                120.0, "");

        Course c5 = new Course(null, "SQL for Developers",
                "Master relational databases and advanced SQL queries.",
                100.99, "");

        Student s1 = new Student(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Student s2 = new Student(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Enrollment e1 = new Enrollment(null, Instant.parse("2019-06-20T19:53:07Z"), EnrollmentStatus.ACTIVE,s1);
        Enrollment e2 = new Enrollment(null, Instant.parse("2019-07-21T03:42:10Z"), EnrollmentStatus.PENDING,s2);
        Enrollment e3 = new Enrollment(null, Instant.parse("2019-07-22T15:21:22Z"), EnrollmentStatus.PENDING,s1);

        studentRepository.saveAll(Arrays.asList(s1, s2));
        enrollmentRepository.saveAll(Arrays.asList(e1,e2, e3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        c1.getCategories().add(cat1);

        c2.getCategories().add(cat2);

        c3.getCategories().add(cat3);

        c4.getCategories().add(cat1);

        c5.getCategories().add(cat1);

        c5.getCategories().add(cat3);

        courseRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

        EnrollmentItem ei1 = new EnrollmentItem(e1, c1, c1.getPrice());
        EnrollmentItem ei2 = new EnrollmentItem(e1, c3, c3.getPrice());
        EnrollmentItem ei3 = new EnrollmentItem(e2, c3, c3.getPrice());
        EnrollmentItem ei4 = new EnrollmentItem(e3, c5, c5.getPrice()); 

        EnrollmentItemRepository.saveAll(Arrays.asList(ei1, ei2, ei3, ei4));
    }
    
}
