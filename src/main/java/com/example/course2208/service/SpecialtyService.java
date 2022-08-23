package com.example.course2208.service;

import com.example.course2208.exception.NoGradesException;
import com.example.course2208.exception.NoSpecialtiesException;
import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Specialty;
import com.example.course2208.model.Student;
import com.example.course2208.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentBySpecialty(Integer specialtyId)
            throws SpecialtyNotFoundException {
        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getStudents();
        }
    }

    public Specialty getMostStudentsSpecialty() throws NoSpecialtiesException {
        Optional<Specialty> tmpSpecialty = specialtyRepository.findAll()
                .stream()
                .max(Comparator.comparingInt(sp -> sp.getStudents().size()));
        if(tmpSpecialty.isEmpty()) {
            throw new NoSpecialtiesException();
        } else {
            return tmpSpecialty.get();
        }
    }

    public Integer getAverageGradeAllStudents(Integer specialtyId)
            throws SpecialtyNotFoundException, NoGradesException {

        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getAverageGradeAllStudents();
        }
    }

    public Student getHighestGradedStudent() {
        return specialtyRepository.findAll()
                .stream()
                .map(sp -> {
                    try {
                        return sp.getHighestGradedStudent();
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                }).max(Comparator.comparingInt(stud -> {
                    try {
                        return stud.getAnnualAverageGrade();
                    } catch (NoGradesException e) {
                        throw new RuntimeException(e);
                    }
                })).get();
    }

    public Student getHighestGradedStudentBySpecialty(Integer specialtyId)
            throws SpecialtyNotFoundException, NoGradesException {

        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getHighestGradedStudent();
        }
    }
}
