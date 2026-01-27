package org.example.day3sms.controller;


import org.example.day3sms.model.StudentModel;
import org.example.day3sms.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public String l(){return "hi there.";}
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add-student")
    public StudentModel addStart(@RequestBody StudentModel student){
        return service.addStudent(student);
    }
    @GetMapping("/students")

    public List<StudentModel> getStudents(){
        return service.getStudents();
    }
}
