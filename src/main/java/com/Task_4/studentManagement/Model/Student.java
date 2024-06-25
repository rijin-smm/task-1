package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
    @Id
    private int roll_no;
    private String student_name;
    private String rank;
    private String studentClass;



    public Student() {
    }

    public Student(int roll_no, String student_name, String rank, String studentClass) {
        super();
        this.roll_no = roll_no;
        this.student_name = student_name;
        this.rank = rank;
        this.studentClass = studentClass;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
