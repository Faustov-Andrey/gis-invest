package ru.itr.giskv.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="address")
public class Address {

    /**
     * Идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @Column(name = "id")
    private Long id;


    /**
     * Ссылка на организацию
     */
    @Column(name = "organization_id", nullable = true)
    private Long organizationId;

    /**
     * Тип адреса
     */
    @Column(name = "type", nullable = true, length = 32)
    private String type;

    /**
     * Индекс
     */
        @Column(name = "zip_code", nullable = true, length = 128)
        private String zipCode;

    /**
     * Страна
     */
        @Column(name = "state", nullable = true, length = 128)
        private String state;

    /**
     * Регион
     */
    @Column(name = "region", nullable = true, length = 128)
    private String region;

    /**
     * Город
     */
    @Column(name = "town", nullable = true, length = 128)
    private String town;

    /**
     * Внутригородской район
     */
    @Column(name = "town_district", nullable = true, length = 128)
    private String townDistrict;

    /**
     * район
     */
    @Column(name = "region_district", nullable = true, length = 128)
    private String regionDistrict;

    /**
     * Поселение
     */
    @Column(name = "settlement", nullable = true, length = 128)
    private String settlement;

    /**
     * Доп. территория
     */
    @Column(name = "territory", nullable = true, length = 128)
    private String territory;

    /**
     * Улица
     */
    @Column(name = "street", nullable = true, length = 128)
    private String street;

    /**
     * Строение
     */
    @Column(name = "structure", nullable = true, length = 32)
    private String structure;

    /**
     * Дом
     */
    @Column(name = "building", nullable = true, length = 32)
    private String building;

    /**
     * Корпус
     */
    @Column(name = "corpus", nullable = true, length = 128)
    private String corpus;

    /**
     * Квартира
     */
    @Column(name = "flat", nullable = true, length = 128)
    private String flat;

    /**
     * Адрес
     */
    @Column(name = "address", nullable = true, length = 256)
    private String addr;

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

    public String getZipCode(){ return zipCode; }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState(){ return state; }
    public void setState(String state) {
        this.state = state;
    }

    public String getRegion(){ return region; }
    public void setRegion(String region) {
        this.region = region;
    }

    public String getTown(){ return town; }
    public void setTown(String town) {
        this.town = town;
    }

    public String getTownDistrict(){ return townDistrict; }
    public void setTownDistrict(String townDistrict) {
        this.townDistrict = townDistrict;
    }

    public String getRegionDistrict(){ return regionDistrict; }
    public void setRegionDistrict(String regionDistrict) {
        this.regionDistrict = regionDistrict;
    }

    public String getSettlement(){ return settlement; }
    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getTerritory(){ return territory; }
    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getStreet(){ return street; }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getStructure(){ return structure; }
    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getBuilding(){ return building; }
    public void setBuilding(String building) {
        this.building = building;
    }


    public String getCorpus(){ return corpus; }
    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }


    public String getFlat(){ return flat; }
    public void setFlat(String flat) {
        this.flat = flat;
    }


    public String getAddr(){ return addr; }
    public void setAddr(String addr) {
        this.addr = addr;
    }


}
