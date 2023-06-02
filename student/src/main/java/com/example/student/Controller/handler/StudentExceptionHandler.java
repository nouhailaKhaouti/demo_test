package com.example.student.Controller.handler;

import com.example.student.exception.Student.StudentCodeNullException;
import com.example.student.exception.Student.StudentExistException;
import com.example.student.exception.Student.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class StudentExceptionHandler {
    final Logger log = LoggerFactory.getLogger(StudentExceptionHandler.class);

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body("Student with " + exception.getCodeM() + " is nowhere to be found");
    }

    @ExceptionHandler(value = StudentExistException.class)
    public ResponseEntity<?> handleStudentExistsException(StudentExistException exception) {
        return ResponseEntity.status(400).body("Student with Code Massar: " + exception.getCodeM() + " is already existing");
    }

    @ExceptionHandler(value = StudentCodeNullException.class)
    public ResponseEntity<?> handleStudentCodeMNullException(StudentCodeNullException exception) {
        return ResponseEntity.status(400).body("Student CodeM is null");
    }
}