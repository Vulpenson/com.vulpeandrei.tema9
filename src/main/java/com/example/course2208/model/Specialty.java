package com.example.course2208.model;

import com.example.course2208.exception.NoGradesException;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    @NotNull
    List<Student> students = new ArrayList<Student>();

    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<Course>();

    // Method to get the average grade based on all students
    public Integer getAverageGradeAllStudents() throws NoGradesException {
        Integer averageGrade = 0;
        for (Student student : students) {
            averageGrade += student.getAnnualAverageGrade();
        }
        return averageGrade/students.size();
    }

    public Student getHighestGradedStudent() throws NoGradesException {
        Student highestGradedStudent = new Student();
        highestGradedStudent.getGrades().add(new Grade(0,0));
        for (Student student : students) {
            if (student.getAnnualAverageGrade() > highestGradedStudent.getAnnualAverageGrade()) {
                highestGradedStudent = student;
            }
        }
        return highestGradedStudent;
    }
}
