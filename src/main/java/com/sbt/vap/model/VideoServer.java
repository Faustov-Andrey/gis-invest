package com.sbt.vap.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="VIDEO_SERVER")
public class VideoServer implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_server_sequence")
    @Column(name = "ID")
    private Long id;

    /**
     * IP адрес видеосервера
     */
    @Column(name = "IP_ADDRESS", nullable = true, length = 32)
    private String ipAddress;

    /**
     * модель видеосервера
     */
    @Column(name = "MODEL", nullable = true, length = 32)
    private String model;

    /**
     * наименование производителя
     */
    @Column(name = "VENDOR_NAME", nullable = true, length = 32)
    private String vendorName;

    /**
     * комментарий
     */
    @Column(name = "DESCRIPTION", nullable = true, length = 512)
    private String description;

    /**
     * комментарий
     */
    @Column(name = "COMMENT", nullable = true, length = 1024)
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
}
