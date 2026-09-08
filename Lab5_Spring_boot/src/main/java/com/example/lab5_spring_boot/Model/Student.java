package com.example.lab5_spring_boot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int ID;
    private String name;
    private int age;
    private double degree;
    private double GPA;
}


