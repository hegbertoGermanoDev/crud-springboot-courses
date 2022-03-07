package com.germano.crudspring.controller;

import com.germano.crudspring.model.Course;
import com.germano.crudspring.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    
    @Autowired
    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course insert(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        Course courseUpdt = new Course();
        courseUpdt.setId(id);
        courseUpdt.setName(course.getName());
        courseUpdt.setCategory(course.getCategory());
        return courseRepository.save(courseUpdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Registro deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
