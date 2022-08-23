package com.example.course2208.exception;

public class NoSpecialtiesException extends Exception {
    public NoSpecialtiesException() {
        super("No specialties found in the database!");
    }
}
