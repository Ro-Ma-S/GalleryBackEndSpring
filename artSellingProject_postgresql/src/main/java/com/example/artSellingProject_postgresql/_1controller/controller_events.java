package com.example.artSellingProject_postgresql._1controller;

import com.example.artSellingProject_postgresql._2service.service_events;
import com.example.artSellingProject_postgresql.table_model.table_events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events_ArtProj")
public class controller_events {
    @Autowired
    private service_events eventsService;

    @GetMapping("/allEvents")
    public List<table_events> getAllEvents()
    {
        return  eventsService.getAllEvents();
    }

    @GetMapping("/eventId/{event_id}")
    public Optional<table_events> getEventById(@PathVariable Integer event_id)
    {
        return eventsService.getEventById(event_id);
    }
    @GetMapping("/organiser_id/{user_id}")
    public List<table_events> getEventsByUserId(@PathVariable Integer user_id) {
        return eventsService.getEventsByUserId(user_id);
    }

    @PostMapping("/add")
    public String addEvent(@RequestBody table_events events)
    {
        return eventsService.addEvent(events);
    }
    @PutMapping("/update")
    public String updateEvent(@RequestBody table_events events)
    {
        return eventsService.updateEvent(events);
    }
    @DeleteMapping("/delete")
    public String deleteEvent(@RequestBody table_events events)
    {
        return eventsService.deleteEvent(events);
    }
}
