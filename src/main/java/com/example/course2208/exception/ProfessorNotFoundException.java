package com.example.course2208.exception;

public class ProfessorNotFoundException extends Exception {
    public ProfessorNotFoundException() {
        super("The professor you are looking for is not existent!");
    }
}
