package com.example.course2208.service;

import com.example.course2208.exception.ProfessorNotFoundException;
import com.example.course2208.model.Course;
import com.example.course2208.model.Professor;
import com.example.course2208.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Course> getAllCourseByProfessor(Integer professorId) throws ProfessorNotFoundException {
        Optional<Professor> tmpOptionalProfessor = professorRepository.findById(professorId);
        if (tmpOptionalProfessor.isEmpty()) {
            throw new ProfessorNotFoundException();
        } else {
            return tmpOptionalProfessor.get().getCourses();
        }
    }
}
