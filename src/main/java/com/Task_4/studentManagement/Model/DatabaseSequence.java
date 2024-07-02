package com.Task_4.studentManagement.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequence")
public class StudentDatabaseSequence {
    @Id
    private String id;
    private long seq;

    public StudentDatabaseSequence() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
