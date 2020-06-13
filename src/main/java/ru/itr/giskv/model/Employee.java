package ru.itr.giskv.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {


    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Ссылка на организацию
     */
    @Column(name = "organization_id", nullable = true)
    private Long organizationId;
    /**
     * ФИО сотрудника
     */
    @Column(name = "fio", nullable = true, length = 128)
    private String fio;

    /**
     * Должность  сотрудника
     */
    @Column(name = "position", nullable = true, length = 128)
    private String position;

    /**
     * Является руководителем
     */
    @Column(name = "directorFlag", nullable = true)
    private Boolean directorFlag;

    /**
     * Документ, удостоверяющий полномочия сотрудника
     */
    @Column(name = "employee_credentials", nullable = true, length = 128)
    private String employeeCredentials;

    /**
     * Тип контакта сотрудника
     */
    @Column(name = "contact_type", nullable = true, length = 32)
    private String contactType;

    /**
     * Значение контакта сотрудника
     */
    @Column(name = "contact_value", nullable = true, length = 32)
    private String contactValue;

    /**
     * Логин в ГИС Капиталовложения
     */
    @Column(name = "giskv_login", nullable = true, length = 32)
    private String giskvLogin;

    /**
     * Логин в ЕСИА
     */
    @Column(name = "esia_login", nullable = true, length = 32)
    private String esiaLogin;


    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public Long getOrganizationId(){ return organizationId; }
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getFio(){ return fio; }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition(){ return position; }
    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getDirectorFlag(){ return directorFlag; }
    public void setDirectorFlag(Boolean directorFlag) {
        this.directorFlag = directorFlag;
    }

    public String getEmployeeCredentials(){ return employeeCredentials; }
    public void setEmployeeCredentials(String employeeCredentials) {
        this.employeeCredentials = employeeCredentials;
    }

    public String getContactType(){ return contactType; }
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue(){ return contactValue; }
    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public String getGiskvLogin(){ return giskvLogin; }
    public void setGiskvLogin(String giskvLogin) {
        this.giskvLogin = giskvLogin;
    }

    public String getEsiaLogin(){ return esiaLogin; }
    public void setEsiaLogin(String esiaLogin) {
        this.esiaLogin = esiaLogin;
    }



}
