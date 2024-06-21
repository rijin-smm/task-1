package com.Task_4.studentManagement.Model;

public class Student {
    private int roll_no;
    private String student_name;
    private String rank;

    public Student() {
    }

    public Student(int roll_no, String student_name, String rank) {
        super();
        this.roll_no = roll_no;
        this.student_name = student_name;
        this.rank = rank;
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
