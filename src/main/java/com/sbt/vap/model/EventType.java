package com.sbt.vap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name="event_type")
public class EventType {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_type_sequence")
    @Column(name = "id")
    private long id;


    /**
     * кодовое обозначение происшествия
     */
    @Column(name = "code", nullable = true, length = 64)
    private String code;

    /**
     * наименование происшествия
     */
    @Column(name = "name", nullable = true, length = 32)
    private String name;

    /**
     * описание
     */
    @Column(name = "description", nullable = true, length = 1024)
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode(){ return code; }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName(){ return name; }
    public void setName(String name) {
        this.name = name;
    }
}
