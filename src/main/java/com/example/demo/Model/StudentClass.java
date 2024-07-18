package com.example.demo.Model;

import jakarta.persistence.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rollNumber;
    private int rank;

    @Temporal(TemporalType.DATE)
    private Date classJoining;

    @Temporal(TemporalType.DATE)
    private Date classEnding;


    @ManyToOne
    @JoinColumn(name = "student_id")
    @Valid
    private Student student;


    @ManyToOne
    @JoinColumn(name = "base_class_id")
    @Valid
    private BaseClass baseClass;

}
