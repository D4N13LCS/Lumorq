package com.lumorq.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lumorq.entities.pk.EnrollmentItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class EnrollmentItem implements Serializable{
    
    @EmbeddedId
    private EnrollmentItemPk id = new EnrollmentItemPk();
    private Double price;
   
    public EnrollmentItem(){}

    public EnrollmentItem(Enrollment enrollment, Course course, Double price) {
        id.setEnrollment(enrollment);
        id.setCourse(course);
        this.price = price;
    }

    @JsonIgnore
    public Enrollment getEnrollment(){
        return id.getEnrollment();
    }

    public void setEnrollment(Enrollment enrollment){
        id.setEnrollment(enrollment);
    }

    public Course getCourse(){
        return id.getCourse();
    }

    public void setCourse(Course course){
        id.setCourse(course);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        EnrollmentItem other = (EnrollmentItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
