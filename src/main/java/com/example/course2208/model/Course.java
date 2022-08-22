package com.example.course2208.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String subject;

    @NotNull
    Integer creditPoints;

    @ManyToOne
    @NotNull
    Professor professor;

    @ManyToOne
    @NotNull
    Specialty specialty;
}
