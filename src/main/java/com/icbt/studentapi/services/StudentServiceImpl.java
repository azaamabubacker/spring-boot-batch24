package com.icbt.studentapi.services;

import com.icbt.studentapi.entity.StudentEntity;
import com.icbt.studentapi.model.Student;
import com.icbt.studentapi.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();

        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        StudentEntity studentEntity =
                studentRepository.findById(id).get();
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity, student);
        return student;
    }
}
