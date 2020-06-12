package com.sbt.vap.controller;

import com.sbt.vap.model.BankUnitType;
import com.sbt.vap.service.BankUnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BankUnitTypeController {
    @Autowired
    private BankUnitTypeService bankUnitTypeService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        //headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех типов подразделений банка из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа BankUnitЕнзу с полным набором атрибутов
     */
    @GetMapping(path = "/v0/bankUnitTypes")
    public List<BankUnitType> getAllBankUnitTypes() {
        List<BankUnitType> bankUnitTypeList = this.bankUnitTypeService.findAll();
        return bankUnitTypeList;
    }
}
