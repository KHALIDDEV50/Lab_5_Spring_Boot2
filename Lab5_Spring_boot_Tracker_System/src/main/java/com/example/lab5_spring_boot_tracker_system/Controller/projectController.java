package com.example.lab5_spring_boot_tracker_system.Controller;


import com.example.lab5_spring_boot_tracker_system.API.apiResponse;
import com.example.lab5_spring_boot_tracker_system.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("api/v1/project")
public class projectController {

    ArrayList<Project> projects = new ArrayList<>();


    // create project
    @PostMapping("/add")
    public apiResponse addProjects(@RequestBody Project project) {

        projects.add(project);
        return new apiResponse("Added Successfully...");
    }

    // get
    @GetMapping("/get")
    public ArrayList<Project> getProject() {
        return projects;
    }

    // Update Project
    @PutMapping("/update/{id}")
    public apiResponse updateProject(@PathVariable int id, @RequestBody Project newProject) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getID() == id) {

                projects.get(i).setTitle(newProject.getTitle());
                projects.get(i).setDescription(newProject.getDescription());
                projects.get(i).setStatus(newProject.isStatus());
                projects.get(i).setCompanyName(newProject.getCompanyName());

                return new apiResponse("Project Updated Successfully");
            }
        }

        return  new apiResponse("Project Not Found");
    }

    // Delete Project
    @DeleteMapping("/delete/{id}")
    public apiResponse deleteProject(@PathVariable int id) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getID() == id) {

                projects.remove(i);

                return new apiResponse ("Project Deleted Successfully");
            }
        }

        return new apiResponse("Project Not Found");
    }


    // Change Status
    @PutMapping("/status/{id}")
    public apiResponse changeStatus(@PathVariable int id, @RequestBody boolean status) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getID() == id) {

                projects.get(i).setStatus(status);

                return new apiResponse("Status Updated Successfully");
            }
        }

        return new apiResponse("Project Not Found");
    }

    // Search by Title
    @GetMapping("/search")
    public Project searchProject(@RequestBody String title) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getTitle().equals(title)) {

                return projects.get(i);
            }
        }

        return null;
    }

    // Get Projects by Company Name
    @GetMapping("/company")
    public ArrayList<Project> getProjectsByCompany(@RequestBody String companyName) {

        ArrayList<Project> result = new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getCompanyName().equals(companyName)) {

                result.add(projects.get(i));
            }
        }

        return result;
    }


}
