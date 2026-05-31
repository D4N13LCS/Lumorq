package com.lumorq.entities.pk;

import java.io.Serializable;

import com.lumorq.entities.Course;
import com.lumorq.entities.Enrollment;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EnrollmentItemPk implements Serializable{

    @ManyToOne
    @JoinColumn(name="enrollmentId")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name="courseId")
    private Course course;

    public EnrollmentItemPk() {
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enrollment == null) ? 0 : enrollment.hashCode());
        result = prime * result + ((course == null) ? 0 : course.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnrollmentItemPk other = (EnrollmentItemPk) obj;
        if (enrollment == null) {
            if (other.enrollment != null)
                return false;
        } else if (!enrollment.equals(other.enrollment))
            return false;
        if (course == null) {
            if (other.course != null)
                return false;
        } else if (!course.equals(other.course))
            return false;
        return true;
    }
    
}
