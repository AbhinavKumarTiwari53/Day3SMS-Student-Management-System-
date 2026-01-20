package org.example.day3sms.service;

import org.example.day3sms.model.StudentModel;
import org.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public  StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

}