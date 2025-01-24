package com.example.demo.mongodb_sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.mongodb_sample.entity.StudentEntity;

public interface StudentRepository extends MongoRepository<StudentEntity, String> {
    // 根據需要添加自定義查詢方法，例如 findByName
    StudentEntity findByName(String name);
}
