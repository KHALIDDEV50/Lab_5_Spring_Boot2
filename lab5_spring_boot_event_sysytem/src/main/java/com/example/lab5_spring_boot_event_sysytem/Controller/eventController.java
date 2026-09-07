package com.example.lab5_spring_boot_event_sysytem.Controller;

import com.example.lab5_spring_boot_event_sysytem.API.ApiResponse;
import com.example.lab5_spring_boot_event_sysytem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

@RequestMapping("api/v1/events")
public class eventController {

    ArrayList<Event> events = new ArrayList<>();

    // create Event..
    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {

        events.add(event);

        return new ApiResponse("Added Successfully...");
    }

    // Display all Event
    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }

    // Update Event
    @PutMapping("/update/{id}")
    public ApiResponse updateEvent(@PathVariable int id, @RequestBody Event newEvent) {

        for (int i = 0; i < events.size(); i++) {

            if (events.get(i).getId() == id) {

                events.get(i).setDescription(newEvent.getDescription());
                events.get(i).setCapacity(newEvent.getCapacity());
                events.get(i).setStartDate(newEvent.getStartDate());
                events.get(i).setEndDate(newEvent.getEndDate());

                return new ApiResponse("Event Updated Successfully");
            }
        }

        return new ApiResponse("Event Not Found");
    }

    // Delete Event

    @DeleteMapping("delete/{id}")
    public ApiResponse deleteEvent(@PathVariable int id) {

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == id) {
                events.remove(i);

                return new ApiResponse("Event Deleted Successfully");
            }
        }
        return new ApiResponse("Event Not Found");
    }

    // change Capacity

    @PutMapping("/capacity/{id}")
    public ApiResponse changeCapacity(@PathVariable int id, @RequestBody int capacity) {

        for (int i = 0; i < events.size(); i++) {

            if (events.get(i).getId() == id) {

                events.get(i).setCapacity(capacity);

                return new ApiResponse("Capacity Updated Successfully");
            }
        }

        return new ApiResponse("Event Not Found");
    }


    // Search by id
    @GetMapping("/search/{id}")
    public Event searchEvent(@PathVariable int id) {

        for (int i = 0; i < events.size(); i++) {

            if (events.get(i).getId() == id) {

                return events.get(i);
            }
        }

        return null;
    }


}
