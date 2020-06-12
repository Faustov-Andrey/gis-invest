package com.sbt.vap.controller;

import com.sbt.vap.model.EventLogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.EventLogRecordService;

import java.sql.Date;
import java.util.List;

@RestController
public class EventLogRecordController {

    @Autowired
    private EventLogRecordService eventLogRecordService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех записей журнала событий из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа EventLogRecord с полным набором атрибутов
     */
    @GetMapping(path = "/v0/eventLogRecords")
    public ResponseEntity<List<EventLogRecord>> getAllEventLogRecords() {
        List<EventLogRecord> eventLogRecordList = this.eventLogRecordService.findAll();
        return new ResponseEntity<>(eventLogRecordList, headers, HttpStatus.OK);
    }

    /**
     * Метод добавления новой записи журнала событий в БД
     * входные параметры: полным набором атрибутов камеры (кроме id)
     * выходные параметры: id новой записи в таблице EventLogRecord
     */
    @PostMapping(path = "/v0/eventLogRecords")
    public boolean newEventLogRecord(long bankUnitId, long cameraId, long nnModelId, Long eventTypeId, Date eventDate, long eventTipeStamp, String description, String comment) {

        //ниже временный код для проверки работы метода saveEvent...()
        EventLogRecord eventLogRecord = new EventLogRecord();
        eventLogRecord.setBankUnitId(bankUnitId);
        eventLogRecord.setCameraId(cameraId);
        eventLogRecord.setNNModelId(nnModelId);
        eventLogRecord.setEventTypeId(eventTypeId);
        eventLogRecord.setEventDate(eventDate);
        eventLogRecord.setEventTimestamp(eventTipeStamp);
        eventLogRecord.setDescription(description);
        eventLogRecord.setComment(comment);

        this.eventLogRecordService.saveEventLogRecord(eventLogRecord);
        return true;
    }


    /**
     * Метод сохранения данных записи журнала событий в БД
     * входные параметры: полным набором атрибутов записи журнала событий
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PutMapping(path = "/v0/eventLogRecords")
    public boolean saveEventLogRecord(long id, long bankUnitId, long cameraId, long nnModelId, long eventTypeId, Date eventDate, long eventTipeStamp, String description, String comment) {

        //ниже временный код для проверки работы метода saveEventLogRecord()
        EventLogRecord eventLogRecord = new EventLogRecord();
        eventLogRecord.setId(id);
        eventLogRecord.setBankUnitId(bankUnitId);
        eventLogRecord.setCameraId(cameraId);
        eventLogRecord.setNNModelId(nnModelId);
        eventLogRecord.setEventTypeId(eventTypeId);
        eventLogRecord.setEventDate(eventDate);
        eventLogRecord.setEventTimestamp(eventTipeStamp);
        eventLogRecord.setDescription(description);
        eventLogRecord.setComment(comment);

        this.eventLogRecordService.saveEventLogRecord(eventLogRecord);
        return true;
    }

    /**
     * Метод удаления записи журнала событий из БД
     * входные параметры: id записи журнала событий
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/v0/eventLogRecords/{id}")
    public boolean deleteEventLogRecordById(@PathVariable("id") long id) {
        EventLogRecord eventLogRecord = this.eventLogRecordService.getEventLogRecordById(id);
        this.eventLogRecordService.deleteEventLogRecord(eventLogRecord);
        return true;
    }

    /**
     * Метод получения списка записей журнала событий из БД по id камеры, типу события, периоду времени
     * входные параметры: id камеры, id типа события, дата и время начала периода
     * выходные параметры: List объектов типа EventLogRecord с полным набором атрибутов
     */
    @GetMapping(path = "/v0/eventLogRecords/cameras/{cameraId}/eventType/{eventTypeId}/startTime/{startDateTime}/stopTime/{stopDateTime}")
    public List<EventLogRecord> getEventLogRecordByCameraIdEventTypeIdPeriod(@PathVariable("cameraId") long cameraId, @PathVariable("eventTypeId") long eventTypeId, @PathVariable("startDateTime") Date startDateTime, @PathVariable("stopDateTime") Date stopDateTime) {
        EventLogRecord eventLogRecord = new EventLogRecord();
        List<EventLogRecord> eventLogRecordList = this.eventLogRecordService.findEventLogRecordByCameraIdEventTypeIdPeriod(cameraId, eventTypeId, startDateTime, stopDateTime);
        return eventLogRecordList;
    }



}
