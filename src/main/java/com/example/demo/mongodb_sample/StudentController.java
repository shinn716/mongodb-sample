package com.example.demo.mongodb_sample;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private StudentRepository studentRepository;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Read (By ID)
    @GetMapping("/{id}")
    public Optional<Student> read(@PathVariable String id) {
        return studentRepository.findById(id);
    }

    // Read (All)
    @GetMapping
    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    // Update
    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        student.setId(id); // 確保更新的是指定 ID 的文檔
        return studentRepository.save(student);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        studentRepository.deleteById(id);
        return "Remove id: " + id;
    }
}
