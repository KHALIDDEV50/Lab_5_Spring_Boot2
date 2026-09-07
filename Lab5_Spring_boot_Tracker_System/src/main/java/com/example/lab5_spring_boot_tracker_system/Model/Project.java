package com.example.lab5_spring_boot_tracker_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private int ID;
    private String title;
    private String description;
    private boolean status;
    private String companyName;
}
