package com.germano.crudspring.repository;

import java.util.List;

import com.germano.crudspring.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByNameContains(String name);

}
