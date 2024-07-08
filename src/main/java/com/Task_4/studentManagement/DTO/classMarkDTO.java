package com.Task_4.studentManagement.DTO;

public class classMarkDTO {
    private long studentId;
    private long subjectId;
    private Double marks;

    public classMarkDTO(long studentId, long subjectId, Double marks) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }
}
