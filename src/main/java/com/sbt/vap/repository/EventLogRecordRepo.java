package com.sbt.vap.repository;
import com.sbt.vap.model.Camera;
import com.sbt.vap.model.EventLogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventLogRecordRepo extends JpaRepository<EventLogRecord, Long> {

    @Query(value = "SELECT i FROM EventLogRecord i WHERE i.cameraId = ?1 AND i.eventTypeId = ?2 AND i.eventDate > ?3 AND i.eventDate <?4")
    List<EventLogRecord> findEventLogRecordByCameraIdEventTypeIdPeriod(final long cameraId, final long eventTypeId, final Date startDateTime, final Date stopDateTime);

}
