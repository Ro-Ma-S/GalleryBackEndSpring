package com.example.artSellingProject_postgresql._2service;


import com.example.artSellingProject_postgresql._3repository_dao.dao_events;
import com.example.artSellingProject_postgresql.table_model.table_events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service_events {

    @Autowired
    private dao_events eventsDao;
    public List<table_events> getAllEvents() {
        return eventsDao.findAll();
    }

    public Optional<table_events> getEventById(Integer eventId) {
        return eventsDao.findById(eventId);
    }

    public List<table_events> getEventsByUserId(Integer userId) {
        return eventsDao.findByUserId(userId);
    }

    public String addEvent(table_events events) {
        eventsDao.save(events);
        return "Event added Successfully";
    }

    public String updateEvent(table_events events) {
        if(eventsDao.existsById(events.getEventId())){
            eventsDao.save(events);
            return "Event updated Successfully";
        }
        else {
            return "Event not found";
        }
    }

    public String deleteEvent(table_events events) {
        if(eventsDao.existsById(events.getEventId())){
            eventsDao.save(events);
            return "Event deleted Successfully";
        }
        else {
            return "Event not found";
        }
    }
}
