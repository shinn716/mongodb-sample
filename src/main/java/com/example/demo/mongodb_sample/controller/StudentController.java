package com.example.demo.mongodb_sample.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mongodb_sample.entity.StudentEntity;
import com.example.demo.mongodb_sample.service.StudentService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/students") // 簡化 URL 前綴
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentEntity create(@RequestBody StudentEntity student) {
        return studentService.create(student);
    }

    // Read (By ID)
    @GetMapping("/{id}")
    public Optional<StudentEntity> read(@PathVariable String id) {
        return studentService.getById(id);
    }

    // Read (All)
    @GetMapping
    public List<StudentEntity> readAll() {
        return studentService.readAll();
    }

    // Update
    @PutMapping("/{id}")
    public StudentEntity update(@PathVariable String id, @RequestBody StudentEntity student) {
        return studentService.update(id, student);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        studentService.deleteById(id);
        return "Remove id: " + id;
    }
}
