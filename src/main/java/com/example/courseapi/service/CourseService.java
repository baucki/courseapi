package com.example.courseapi.service;

import com.example.courseapi.exception.CourseNotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course by id" + id + "was not found"));
    }
}
