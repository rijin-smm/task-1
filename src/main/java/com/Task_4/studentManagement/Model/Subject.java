package com.Task_4.studentManagement.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subject")
public class Subject {
    @Id
    private String subject_id;
    private String subject_name;

    public Subject(String subject_id, String subject_name) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
}
