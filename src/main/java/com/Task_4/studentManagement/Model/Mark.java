package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
public class Mark {
    @Id
    private String markId;
    private String studentName;
    private String subjectName;
    private double marks;

    public Mark() {
    }

    public Mark(String markId, String studentName, String subjectName, double marks) {
        this.markId = markId;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
