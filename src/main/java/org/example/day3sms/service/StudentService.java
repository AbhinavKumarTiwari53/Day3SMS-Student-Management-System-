package org.example.day3sms.service;

import org.example.day3sms.model.StudentModel;
import org.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public  StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

    //Display Student
    @GetMapping("/students")

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    //update
    public StudentModel updateStudents(String id , StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(()->new RuntimeException("No Student Found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }
}