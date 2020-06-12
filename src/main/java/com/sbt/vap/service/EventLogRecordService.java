package com.sbt.vap.service;

import com.sbt.vap.model.EventLogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.EventLogRecordRepo;

import java.sql.Date;
import java.util.List;

@Service
public class EventLogRecordService {

    @Autowired
    private EventLogRecordRepo eventLogRecordRepo;

    public void saveEventLogRecord(final EventLogRecord eventLogRecord) {
        this.eventLogRecordRepo.saveAndFlush(eventLogRecord);
    }

    public List<EventLogRecord> findAll() {
        return this.eventLogRecordRepo.findAll();
    }

    public EventLogRecord getEventLogRecordById(final long id){
        return this.eventLogRecordRepo.getOne(id);
    }

    public EventLogRecord getEventLogRecordByCameraId(final long id){
        return this.eventLogRecordRepo.getOne(id);
    }

    public void deleteEventLogRecord(final EventLogRecord eventLogRecord){
        this.eventLogRecordRepo.delete(eventLogRecord);
    }

    public List<EventLogRecord> findEventLogRecordByCameraIdEventTypeIdPeriod(long cameraId, long eventTypeId, Date startDateTime, Date stopDateTime) {
        List<EventLogRecord> eventLogRecordList = this.eventLogRecordRepo.findEventLogRecordByCameraIdEventTypeIdPeriod(cameraId, eventTypeId, startDateTime, stopDateTime);
        int i=0;
        return eventLogRecordList;
    }


}
