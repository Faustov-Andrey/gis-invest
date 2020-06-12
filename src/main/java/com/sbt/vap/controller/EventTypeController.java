package com.sbt.vap.controller;

import com.sbt.vap.model.EventType;
import com.sbt.vap.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventTypeController {
    @Autowired
    private EventTypeService eventTypeService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех типов событий из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа EventType с полным набором атрибутов
     */
    @GetMapping(path = "/v0/eventTypes")
    public ResponseEntity<List<EventType>> getAllEventTypes() {
        List<EventType> eventTypeList = this.eventTypeService.findAll();
        return new ResponseEntity<>(eventTypeList, headers, HttpStatus.OK);
    }

    /**
     * Метод получения данных типа события из БД по id
     * входные параметры: id типа события
     * выходные параметры: объект типа EventType с полным набором атрибутов
     */
    @GetMapping(path = "/v0/eventTypes/{id}")
    public EventType getEventTypeById(@PathVariable("id") long id) {
        return this.eventTypeService.findEventTypeById(id);
    }


}
