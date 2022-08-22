package com.example.course2208.controller;

import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Student;
import com.example.course2208.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("all/{specialtyId}")
    public List<Student> getAllStudentBySpecialty(@PathVariable Integer specialtyId)
            throws SpecialtyNotFoundException {
        return specialtyService.getAllStudentBySpecialty(specialtyId);
    }
}
