package org.example.day3sms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel {
    @Id // primary key --> @Id (annotator)
    private String id;
    private String name;
    private int age;
    private String email;

}
