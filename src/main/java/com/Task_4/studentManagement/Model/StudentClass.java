package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "student_class")
public class StudentClass {
    @Id
    private String student_class_id;
    private String student_class_name;

    public StudentClass(String student_class_id, String student_class_name) {
        this.student_class_id = getStudent_class_id();
        this.student_class_name = getStudent_class_name();
    }

    public String getStudent_class_id() {
        return student_class_id;
    }

    public void setStudent_class_id(String student_class_id) {
        this.student_class_id = student_class_id;
    }

    public String getStudent_class_name() {
        return student_class_name;
    }

    public void setStudent_class_name(String student_class_name) {
        this.student_class_name = student_class_name;
    }
}
