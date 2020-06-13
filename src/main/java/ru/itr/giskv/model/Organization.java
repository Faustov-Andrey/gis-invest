package ru.itr.giskv.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="organization")
public class Organization implements Serializable {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Полное наименование
     */
    @Column(name = "org_form", nullable = true, length = 128)
    private String orgForm;

    /**
     * Полное наименование
     */
    @Column(name = "full_name", nullable = true, length = 128)
    private String fullName;

    /**
     * Сокращенное наименование
     */
    @Column(name = "short_name", nullable = true, length = 128)
    private String shortName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = true)
    private Long inn;

    /**
     * КПП
     */
    @Column(name = "kpp", nullable = true)
    private Long kpp;

    /**
     * ОГРН
     */
    @Column(name = "ogrn", nullable = true)
    private Long ogrn;

    /**
     * ОКПО
     */
    @Column(name = "okpo", nullable = true)
    private Long okpo;

    /**
     * ОКВЭД (основной)
     */
    @Column(name = "okved", nullable = true)
    private Long okved;

    /**
     * Расчетный счет организации (БИК, БАНК)
     */
    @Column(name = "share_capital", nullable = true, length = 128)
    private String shareCapital;

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

    public String getOrgForm(){ return orgForm; }
    public void setOrgForm(String orgForm) {
        this.orgForm = orgForm;
    }

    public String getFullName(){ return fullName; }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName(){ return shortName; }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getInn(){ return inn; }
    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp(){ return kpp; }
    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public Long getOgrn(){ return ogrn; }
    public void setOgrn(Long ogrn) {
        this.ogrn = ogrn;
    }

    public Long getOkpo(){ return okpo; }
    public void setOkpo(Long okpo) {
        this.okpo = okpo;
    }

    public Long getOkved(){ return okved; }
    public void setOkved(Long okved) {
        this.okved = okved;
    }

    public String getShareCapital(){ return shareCapital; }
    public void setShareCapital(String shareCapital) {
        this.shareCapital = shareCapital;
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
