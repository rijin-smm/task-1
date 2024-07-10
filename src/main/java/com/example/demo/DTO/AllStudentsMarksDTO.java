package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllStudentsMarksDTO {
    private Long studentId;
    private String studentName;
    private int age;
    private String className;
    private Map<String, Double> marks;
}
