package com.example.course2208.controller;

import com.example.course2208.exception.NoGradesException;
import com.example.course2208.exception.NoSpecialtiesException;
import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Specialty;
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

    @GetMapping("mostStudents")
    public Specialty getMostStudentsSpecialty() throws NoSpecialtiesException {
        return specialtyService.getMostStudentsSpecialty();
    }

    @GetMapping("averageGrade/{specialtyId}")
    public Integer getAverageGradeAllStudents(@PathVariable Integer specialtyId)
            throws SpecialtyNotFoundException, NoGradesException {
        return specialtyService.getAverageGradeAllStudents(specialtyId);
    }

    @GetMapping("highestGradedStudent")
    public Student getHighestGradedStudent() {
        return specialtyService.getHighestGradedStudent();
    }

    @GetMapping("highestGradedStudent/{specialtyId}")
    public Student getHighestGradedStudentBySpecialty(@PathVariable Integer specialtyId)
            throws NoGradesException, SpecialtyNotFoundException {
        return specialtyService.getHighestGradedStudentBySpecialty(specialtyId);
    }
}
