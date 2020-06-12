package com.sbt.vap.service;

import com.sbt.vap.model.Camera;
import com.sbt.vap.model.EventType;
import com.sbt.vap.repository.EventTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeService {
    @Autowired
    private EventTypeRepo eventTypeRepo;

    public List<EventType> findAll() {
        return this.eventTypeRepo.findAll();
    }

    public EventType findEventTypeById(Long id){
        return this.eventTypeRepo.getOne(id);
    }


}
