package com.example.course2208.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<>();

    @OneToMany
    @NotNull
    List<Project> projects = new ArrayList<>();

    String firstName;
    String lastName;
}
