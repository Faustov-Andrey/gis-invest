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
    @Column(name = "full_name", nullable = true)
    private String fullName;

    /**
     * Сокращенное наименование
     */
    @Column(name = "short_name", nullable = true)
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
     * Юридический адрес
     */
    @Column(name = "legal_address", nullable = true, length = 128)
    private String legalAddress;

    /**
     * Почтовый адрес
     */
    @Column(name = "post_address", nullable = true, length = 128)
    private String postAddress;

    /**
     * Проектная компания
     */
    @Column(name = "design_company", nullable = true, length = 128)
    private String designCompany;

    /**
     * Сведения о лице, имеющем право без доверенности действовать от имени юридического лица (ФИО)
     */
    @Column(name = "representative_persone_name", nullable = true, length = 128)
    private String representativePersoneName;

    /**
     * ИНН лица, имеющем право без доверенности действовать от имени юридического лица
     */
    @Column(name = "representative_persone_inn", nullable = true)
    private Long representativePersoneInn;

    /**
     * Адрес электронной почты уполномоченного лица
     */
    @Column(name = "representative_persone_email", nullable = true, length = 128)
    private String representativePersoneEmail;

    /**
     * Телефон уполномоченного лица
     */
    @Column(name = "representative_persone_phone", nullable = true, length = 128)
    private String representativePersonePhone;

    /**
     * Сведения об учредителях (участниках) юридического лица (наименование)
     */
    @Column(name = "founder_name", nullable = true, length = 128)
    private String founderName;

    /**
     * Сведения об учредителях (участниках) юридического лица (ИНН)
     */
    @Column(name = "founder_inn", nullable = true, length = 128)
    private String founderInn;

    /**
     * Расчетный счет организации (БИК, БАНК)
     */
    @Column(name = "bank_account_number", nullable = true, length = 128)
    private String bankAccountNumber;

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

    public String getFullName(){ return fullName; }
    public void setFullName(String userId) {
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

    public String getLegalAddress(){ return legalAddress; }
    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getPostAddress(){ return postAddress; }
    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getDesignCompany(){ return designCompany; }
    public void setDesignCompany(String designCompany) {
        this.designCompany = designCompany;
    }

    public String getRepresentativePersoneName(){ return representativePersoneName; }
    public void setRrepresentativePersoneName(String representativePersoneName) {
        this.representativePersoneName = representativePersoneName;
    }

    public Long getRepresentativePersoneInn(){ return representativePersoneInn; }
    public void setRepresentativePersoneInn(Long representativePersoneInn) {
        this.representativePersoneInn = representativePersoneInn;
    }

    public String getRepresentativePersoneEmail(){ return representativePersoneEmail; }
    public void setRepresentativePersoneEmail(String representativePersoneEmail) {
        this.representativePersoneEmail = representativePersoneEmail;
    }

    public String getRepresentativePersonePhone(){ return representativePersonePhone; }
    public void setRepresentativePersonePhone(String representativePersonePhone) {
        this.representativePersonePhone = representativePersonePhone;
    }

    public String getFounderName(){ return founderName; }
    public void setFounderName(String foundersNames) {
        this.founderName = founderName;
    }

    public String getFounderInn(){ return founderInn; }
    public void setFounderInn(String founderInn) {
        this.founderInn = founderInn;
    }

    public String getBankAccountNumber(){ return bankAccountNumber; }
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
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
