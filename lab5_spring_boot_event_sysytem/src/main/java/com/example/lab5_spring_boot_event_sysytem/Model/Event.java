package com.example.lab5_spring_boot_event_sysytem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;
    private LocalDate startDate;
    private LocalDate endDate;
}
