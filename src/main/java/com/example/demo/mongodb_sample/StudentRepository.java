package com.example.demo.mongodb_sample;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // 根據需要添加自定義查詢方法，例如 findByName
    Student findByName(String name);
}
