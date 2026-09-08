package com.example.lab5_spring_boot.Controller;

import com.example.lab5_spring_boot.API.ApiResponse;
import com.example.lab5_spring_boot.Model.Student;
import org.springframework.web.bind.annotation.*;
//import com.example.lab5_spring_boot.API.apiRecponce;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("api/v1/")
public class studentController {

    ArrayList<Student> students = new ArrayList<>();

    // Get. done
    @GetMapping("/get")
    public ArrayList<Student> getStudent() {
        return students;
    }

    // add Student
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {

        students.add(student);

        return new ApiResponse("Added Successfully");
    }

    // update Student..
    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Update  Successful");
    }

    // delete Student
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Delete  Successful");
    }

    // classifyBasedStudent
    @GetMapping("/get/classify")
    public ArrayList<Student> getClassifyBasedStudent() {

        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getDegree() >= 60) {
                result.add(students.get(i));
            }
        }
        return result;
    }

    //
    @GetMapping("/get/above-average")
    public ArrayList<Student> getStudentsAboveAverageGPA() {
        ArrayList<Student> result = new ArrayList<>();

        double sum = 0;

        // Calculate total GPA
        for (int i = 0; i < students.size(); i++) {

            sum = sum + students.get(i).getGPA();
        }
        double average = sum / students.size();

        // Get students above average
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGPA() > average) {
                result.add(students.get(i));
            }
        }
        return result;
    }

}



