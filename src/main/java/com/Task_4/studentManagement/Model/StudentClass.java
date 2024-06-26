package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_class")
public class StudentClass {
    @Id
    private String Id;
    private String studentName;
    private String studentClassId;

    public StudentClass() {
    }

    public StudentClass(String Id, String studentName,String studentClassId) {
        this.studentClassId = studentClassId;
        this.Id = Id;
        this.studentName = studentName;
    }

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
