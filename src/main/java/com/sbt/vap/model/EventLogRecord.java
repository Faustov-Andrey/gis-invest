package com.sbt.vap.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="event_log_record")
public class EventLogRecord  implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_log_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * идентификатор ВСП
     */
    @Column(name = "bank_unit_id", nullable = true)
    private Long bankUnitId;

    /**
     * идентификатор камеры
     */
    @Column(name = "camera_id", nullable = true)
    private Long cameraId;

    /**
     * идентификатор камеры
     */
    @Column(name = "nn_model_id", nullable = true)
    private Long nnModelId;

    /**
     * тип события
     */
    @Column(name = "event_type_id", nullable = true, length = 128)
    private Long eventTypeId;

    /**
     * тип события
     */
    @Column(name = "date", nullable = true, length = 128)
    private Date eventDate;

    /**
     * момент возникновения события
     */
    @Column(name = "timestamp", nullable = true, length = 128)
    private Long eventTimestamp;

    /**
     * кадр
     */
    @Column(name = "cadr", nullable = true, length = 1024)
    @Lob
    private Blob cadr;

    /**
     * описание
     */
    @Column(name = "description", nullable = true, length = 512)
    private String description;

    /**
     * комментарий
     */
    @Column(name = "comment", nullable = true, length = 1024)
    private String comment;

    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public Long getBankUnitId(){ return bankUnitId; }
    public void setBankUnitId(Long bankUnitId) {
        this.bankUnitId = bankUnitId;
    }

    public Long getCameraId(){ return cameraId; }
    public void setCameraId(Long cameraId) {
        this.cameraId = cameraId;
    }

    public Long getNNModelId(){ return nnModelId; }
    public void setNNModelId(Long nnModelId) {
        this.nnModelId = nnModelId;
    }

    public Long getEventTypeId(){ return eventTypeId; }
    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Date getEventDate(){ return eventDate; }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Blob getCadr(){ return cadr; }
    public void setCadr(Blob cadr) {
        this.cadr = cadr;
    }

    public Long getEventTimestamp(){ return eventTimestamp; }
    public void setEventTimestamp(Long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description= description;
    }

    public String getComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }


}
