package com.sbt.vap.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="nn_model")
public class NNModel implements Serializable {
    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nnmodel_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * имя нейросети
     */
    @Column(name = "name", nullable = true, length = 32)
    private String name;

    /**
     * CPU или GPU
     */
    @Column(name = "type_cp", nullable = true, length = 512)
    private String typeCp;

    /**
     * количество ядер
     */
    @Column(name = "cores", nullable = true)
    private Long cores;

    /**
     * объем памяти
     */
    @Column(name = "ram", nullable = true)
    private Long ram;

    /**
     * URL
     */
    @Column(name = "url", nullable = true, length = 512)
    private String url;

    /**
     * системное имя
     */
    @Column(name = "system_name", nullable = true, length = 512)
    private String systemName;

    /**
     * версия
     */
    @Column(name = "version", nullable = true, length = 512)
    private String version;


    /**
     * активность
     */
    @Column(name = "activity", nullable = true)
    private Boolean activity;

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

    public String getTypeCp(){ return typeCp; }
    public void setTypeCp(String typeCp) {
        this.typeCp = typeCp;
    }

    public Long getCores(){ return cores; }
    public void setCores(long cores) {
        this.cores = cores;
    }

    public Long getRam(){ return ram; }
    public void setRam(long ram) {
        this.ram = ram;
    }

    public String getUrl(){ return url; }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getSystemName(){ return systemName; }
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getVersion(){ return version; }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription(){ return description; }
    public void setDescription(String description) {
        this.description= description;
    }

    public boolean getActivity(){ return activity; }
    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public String getComment(){ return comment; }
    public void setComment(String comment) {
        this.comment = comment;
    }


}