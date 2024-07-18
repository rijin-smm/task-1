package com.Task_4.studentManagement.DTO;

import java.util.Map;

public class studentMarksDTO {
    private long studentId;
    private String studentName;
    private String className;
    private int age;
    private Double avgMark;
    private Map<String ,Double> marks;

    public studentMarksDTO() {
    }

    public studentMarksDTO(String className,long studentId, String studentName, int age, Map<String ,Double> marks, Double avgMark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.marks = marks;
        this.avgMark = avgMark;
        this.className = className;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Double> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Double> marks) {
        this.marks = marks;
    }

    public Double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Double avgMark) {
        this.avgMark = avgMark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
