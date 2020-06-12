package com.sbt.vap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name="bank_unit_type")
public class BankUnitType {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_unit_type_sequence")
    @Column(name = "id")
    private Long id;


    /**
     * наименование типа подразделения
     */
    @Column(name = "name", nullable = true, length = 32)
    private String name;

    /**
     * описание
     */
    @Column(name = "description", nullable = true, length = 1024)
    private String description;


    /**
     * Ссылка на сущность 'bankUnit'
     */
    @JsonBackReference
    @OneToMany(mappedBy = "bankUnitType", fetch = FetchType.LAZY)
    private List<BankUnit> bankUnits;

    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getName(){ return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description = description;
    }

}
