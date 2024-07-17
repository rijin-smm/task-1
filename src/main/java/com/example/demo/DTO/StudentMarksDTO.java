package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentMarksDTO {
    private String studentName;
    private String ClassName;
    private Double avgMark;
    private Map<String, Double> marks;
}
