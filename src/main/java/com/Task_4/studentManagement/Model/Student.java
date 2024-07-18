package com.Task_4.studentManagement.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";

    @Id
    private long id;
    @NotEmpty(message = "Student name must not be empty")
    @Size(min = 2, max = 50, message = "Student name must be between 2 and 50 characters")
    private String studentName;

    @NotNull(message = "Age must not be null")
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    public Student() {
    }

    public Student(String studentName,int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
