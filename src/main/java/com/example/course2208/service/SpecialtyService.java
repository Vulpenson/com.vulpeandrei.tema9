package com.example.course2208.service;

import com.example.course2208.exception.SpecialtyNotFoundException;
import com.example.course2208.model.Specialty;
import com.example.course2208.model.Student;
import com.example.course2208.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudentBySpecialty(Integer specialtyId) throws SpecialtyNotFoundException {
        Optional<Specialty> tmpOptionalSpecialty = specialtyRepository.findById(specialtyId);
        if (tmpOptionalSpecialty.isEmpty()) {
            throw new SpecialtyNotFoundException();
        } else {
            return tmpOptionalSpecialty.get().getStudents();
        }
    }
}
