package com.example.course2208.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public String project;

    @ManyToOne
    @NotNull
    Professor professor;
}
