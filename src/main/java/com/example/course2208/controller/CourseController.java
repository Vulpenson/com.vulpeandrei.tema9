package com.example.course2208.controller;

import com.example.course2208.model.Course;
import com.example.course2208.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("all/greaterThanThree")
    public List<Course> getAllCoursesCreditPointsGreaterThanThree() {
        return courseService.getAllCoursesCreditPointsGreaterThanThree();
    }
}
