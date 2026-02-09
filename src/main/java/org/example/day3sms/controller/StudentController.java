package org.example.day3sms.controller;


import jakarta.validation.Valid;
import org.example.day3sms.DTO.StudentRequestDto;
import org.example.day3sms.DTO.StudentResponseDto;
import org.example.day3sms.model.StudentModel;
import org.example.day3sms.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @GetMapping("/")
    public String l(){return "hi there.";}
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add-student")
    public StudentResponseDto addStart(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }


    //Display Student
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getAllStudents();
    }

    //update Student
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
        return service.updateStudents(id,student);
    }

    //Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
