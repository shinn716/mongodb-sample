package com.example.demo.mongodb_sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mongodb_sample.entity.StudentEntity;
import com.example.demo.mongodb_sample.repository.StudentRepository;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity create(StudentEntity student) {
        return studentRepository.save(student);
    }

    public Optional<StudentEntity> getById(String id) {
        return studentRepository.findById(id);
    }

    public List<StudentEntity> readAll() {
        return studentRepository.findAll();
    }

    public StudentEntity update(String id, StudentEntity student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public String deleteById(String id) {
        studentRepository.deleteById(id);
        return id;
    }

}
