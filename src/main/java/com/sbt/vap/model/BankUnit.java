package com.sbt.vap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "public", name="bank_unit")
public class BankUnit  implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_unit_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Ссылка на сущность 'camera'
     * Список камер, установленных в этом ВСП
     */
    @JsonBackReference
    @OneToMany(mappedBy = "bankUnit", fetch = FetchType.LAZY)
    private List<Camera> cameraList;

    /**
     * Ссылка на сущность 'тип подразделения'
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", nullable = true)
    private BankUnit bankUnitType;

    /**
     * имя подразделения
     */
    @Column(name = "name", nullable = true, length = 128)
    private String name;

    /**
     * номер подразделения
     */
    @Column(name = "number", nullable = true, length = 32)
    private String number;

    /**
     * адрес подразделения
     */
    @Column(name = "address", nullable = true, length = 128)
    private String address;

    /**
     * телефон подразделения
     */
    @Column(name = "phone_number", nullable = true, length = 512)
    private String phoneNumber;

    /**
     * описание
     */
    @Column(name = "description", nullable = true, length = 1024)
    private String description;

    /**
     * комментарий
     */
    @Column(name = "comment", nullable = true, length = 1024)
    private String comment;

    /**
     * id вышестоящего подразделения
     */
    @Column(name = "parent_id", nullable = true, insertable = false, updatable = false)
    private Long parentId;

    /**
     * id вышестоящего подразделения
     */
    @Column(name = "type_id", nullable = true, insertable = false, updatable = false)
    private Long typeId;

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

    public String getNumber(){ return number; }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress(){ return address; }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getParentId(){ return parentId; }
    public void setParentId(Long id) {
        this.parentId = id;
    }

    public Long getTypeId(){ return typeId; }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

}
