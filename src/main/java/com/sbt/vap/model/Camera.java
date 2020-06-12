package com.sbt.vap.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CAMERA")
public class Camera implements Serializable {
    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "camera_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Ссылка на сущность 'ВСП'
     */
    /*@ManyToOne(fetch = FetchType.LAZY)*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_unit_id", nullable = true)
    private BankUnit bankUnit;

    /**
     * IP адрес камеры
     */
    @Column(name = "bank_unit_id", nullable = true, insertable = false, updatable = false)
    private long bankUnitId;

    /**
     * IP адрес камеры
     */
    @Column(name = "ip_address", nullable = true, length = 32)
    private String ipAddress;

    /**
     * имя камеры (например entrance, zone24, mainholl)
     */
    @Column(name = "name", nullable = true, length = 128)
    private String name;

    /**
     * модель камеры
     */
    @Column(name = "model", nullable = true, length = 32)
    private String model;

    /**
     * наименование производителя
     */
    @Column(name = "vendor_name", nullable = true, length = 32)
    private String vendorName;

    /**
     * Login для доступа к камере
     */
    @Column(name = "access_login", nullable = true, length = 32)
    private String accessLogin;

    /**
     * Pwd для доступа к камере
     */
    @Column(name = "access_pwd", nullable = true, length = 32)
    private String accessPwd;

    /**
     * комментарий
     */
    @Column(name = "description", nullable = true, length = 1024)
    private String description;

    /**
     * комментарий
     */
    @Column(name = "comment", nullable = true, length = 32)
    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getIPAddress(){ return ipAddress; }
    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAccessLogin(){ return accessLogin; }
    public void setAccessLogin(String accessLogin) {
        this.accessLogin= accessLogin;
    }

    public String getAccessPwd(){ return accessPwd; }
    public void setAccessPwd(String accessPwd) {
        this.accessPwd = accessPwd;
    }

    public String getName(){ return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getModel(){ return model; }
    public void setModel(String model) {
        this.model = model;
    }

    public String getVendorName(){ return vendorName; }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }


    public String toString(){
        StringBuilder result = new StringBuilder("Request --> ");
        //???
        return result.toString();
    }
}
