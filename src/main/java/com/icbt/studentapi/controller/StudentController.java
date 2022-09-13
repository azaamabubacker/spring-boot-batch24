package com.icbt.studentapi.controller;

import com.icbt.studentapi.model.Student;
import com.icbt.studentapi.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
//    public Student saveStudent(@RequestBody Student student) {
//        return StudentService.saveStudent(student);
//    }
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = null;
        student = studentService.getStudent(id);
        return  ResponseEntity.ok(student);
    }




}
