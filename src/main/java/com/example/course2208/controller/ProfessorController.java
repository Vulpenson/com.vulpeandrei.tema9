package com.example.course2208.controller;

import com.example.course2208.exception.ProfessorNotFoundException;
import com.example.course2208.model.Course;
import com.example.course2208.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("courses/{professorId}")
    public List<Course> getAllCourseByProfessor(@PathVariable Integer professorId)
        throws ProfessorNotFoundException {
        return professorService.getAllCourseByProfessor(professorId);
    }
}
