package ru.itr.giskv.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="organization_owner")
public class OrganizationOwner {


    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_owner_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Ссылка на организацию
     */
    @Column(name = "organization_id", nullable = true, length = 32)
    private Long organizationId;

    /**
     * Тип (ФЛ, ЮЛ)
     */
    @Column(name = "type", nullable = true, length = 32)
    private String type;

    /**
     * Доля акций, принадлежащих владельцу
     */
    @Column(name = "shares_proportion", nullable = true, length = 128)
    private String sharesProportion;

    /**
     * Доля в уставном капитале
     */
    @Column(name = "capital_shares", nullable = true, length = 128)
    private String capitalShares;

    /**
     * ОПФ владельца
     */
    @Column(name = "owner_opf", nullable = true, length = 128)
    private String ownerOpf;

    /**
     * Полное наименование (ЮЛ)
     */
    @Column(name = "owner_full_name", nullable = true, length = 128)
    private String ownerFullName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = true, length = 32)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", nullable = true, length = 32)
    private String kpp;

    /**
     * ОГРН
     */
    @Column(name = "ogrn", nullable = true, length = 128)
    private String ogrn;

    /**
     * ФИО владельца (ФЛ)
     */
    @Column(name = "director_full_name", nullable = true, length = 128)
    private String directorFullName;

    /**
     * Дата рождения владельца
     */
    @Column(name = "birth_date", nullable = true, length = 128)
    private String birthDate;


    /**
     * Место рождения
     */
    @Column(name = "birth_place", nullable = true, length = 128)
    private String birthPlace;

    /**
     * Гражданство
     */
    @Column(name = "citizenship", nullable = true, length = 128)
    private String citizenship;

    /**
     * Реквизиты документа, удостоверяющего личность
     */
    @Column(name = "identification_document", nullable = true, length = 128)
    private String identificationDocument;

    /**
     * Данные документа, подтверждающего право иностранного гражданина или лица без гражданства на пребывание (проживание) в РФ
     */
    @Column(name = "residence_right_document", nullable = true, length = 128)
    private String residenceRightDocument;

    /**
     * Адрес места жительства (регистрации) или места пребывания на территории РФ
     */
    @Column(name = "residence_address", nullable = true, length = 128)
    private String residenceAddress;

    /**
     * Тип контакта владельца (ФЛ) Телефон, Факс, Эл.почта
     */
    @Column(name = "contact_type", nullable = true, length = 128)
    private String contactType;

    /**
     * Значение контакта владельца
     */
    @Column(name = "contact_value", nullable = true, length = 128)
    private String contactValue;

    /**
     * Бенефициарный владелец
     */
    @Column(name = "beneficial_owner_flag", nullable = true, length = 128)
    private Boolean beneficialOwnerFlag;


    /**
     * Налоговый резидент РФ
     */
    @Column(name = "tax_resident_flag", nullable = true, length = 128)
    private Boolean taxResidentFlag;



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

    public String getType(){ return type; }
    public void setType(String type) {
        this.type = type;
    }

    public String getSharesProportion(){ return sharesProportion; }
    public void setSharesProportion(String sharesProportion) {
        this.sharesProportion = sharesProportion;
    }

    public String getCapitalShares(){ return capitalShares; }
    public void setCapitalShares(String capitalShares) {
        this.capitalShares = capitalShares;
    }

    public String getOwnerOpf(){ return ownerOpf; }
    public void setOwnerOpf(String ownerOpf) {
        this.ownerOpf = ownerOpf;
    }

    public String getOwnerFullName(){ return ownerFullName; }
    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getInn(){ return inn; }
    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp(){ return kpp; }
    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getOgrn(){ return ogrn; }
    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getDirectorFullName(){ return directorFullName; }
    public void setDirectorFullName(String directorFullName) {
        this.directorFullName = directorFullName;
    }

    public String getBirthDate(){ return birthDate; }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace(){ return birthPlace; }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCitizenship(){ return citizenship; }
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getIdentificationDocument(){ return identificationDocument; }
    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public String getResidenceRightDocument(){ return residenceRightDocument; }
    public void setResidenceRightDocument(String residenceRightDocument) {
        this.residenceRightDocument = residenceRightDocument;
    }

    public String getResidenceAddress(){ return residenceAddress; }
    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getContactType(){ return contactType; }
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue(){ return contactValue; }
    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public Boolean getBeneficialOwnerFlag(){ return beneficialOwnerFlag; }
    public void setBeneficialOwnerFlag(Boolean beneficialOwnerFlag) {
        this.beneficialOwnerFlag = beneficialOwnerFlag;
    }

    public Boolean getTaxResidentFlag(){ return taxResidentFlag; }
    public void setTaxResidentFlag(Boolean taxResidentFlag) {
        this.taxResidentFlag = taxResidentFlag;
    }




}
