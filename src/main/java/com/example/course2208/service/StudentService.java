package com.example.course2208.service;

import com.example.course2208.exception.NoGradesException;
import com.example.course2208.exception.StudentNotFoundException;
import com.example.course2208.model.Grade;
import com.example.course2208.model.Student;
import com.example.course2208.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void addGrade(Grade grade, Integer studentId) throws StudentNotFoundException {
        Optional<Student> tmpOptionalStudent = studentRepository.findById(studentId);
        if (tmpOptionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            tmpOptionalStudent.get().getGrades().add(grade);
            studentRepository.save(tmpOptionalStudent.get());
        }
    }

    public List<Grade> getAllGradesByStudent(Integer studentId) throws StudentNotFoundException {
        Optional<Student> tmpOptionalStudent = studentRepository.findById(studentId);
        if (tmpOptionalStudent.isEmpty()) {
            throw new StudentNotFoundException();
        } else {
            Student tmpStudent = tmpOptionalStudent.get();
            return tmpStudent.getGrades();
        }
    }

    public List<Student> getAllStudentsGradeGreaterThanEight() {
        return studentRepository.findAll().stream().filter((Student student) -> {
            try {
                return student.getAnnualAverageGrade() >= 8;
            } catch (NoGradesException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
