package com.icbt.studentapi.services;

import com.icbt.studentapi.model.Student;

public interface StudentService {
 Student getStudent(Long id);

 Student saveStudent(Student student);
}
