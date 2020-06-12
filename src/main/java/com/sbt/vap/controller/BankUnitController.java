package com.sbt.vap.controller;

import com.sbt.vap.model.BankUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.BankUnitService;

import java.util.List;

@RestController
@CrossOrigin
public class BankUnitController {

    @Autowired
    private BankUnitService bankUnitService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        //headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех подразделений банка из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа BankUnit с полным набором атрибутов
     */
    //@GetMapping(path = "/v0/bankUnits")
    public List<BankUnit> getAllBankUnits() {
        List<BankUnit> bankUnitList = this.bankUnitService.findAll();
        return bankUnitList;
    }

    /**
     * Метод получения из БД списка подразделений банка дочерних для выбранного подразделения
     * входные параметры: parentId
     * выходные параметры: List объектов типа BankUnit с полным набором атрибутов
     */
    @GetMapping(path = "/v0/parentBankUnit/{parentId}/bankUnits")//http://127.0.0.1:8080/v0/parentBankUnit/{parentId}/bankUnits
    public ResponseEntity<List<BankUnit>> getBankUnitsByParentId(@PathVariable("parentId") Long parentId) {
        List<BankUnit> bankUnitList = this.bankUnitService.findByParentId(parentId);
        return new ResponseEntity<>(bankUnitList, headers, HttpStatus.OK);
    }
    /**
     * Метод добавления нового подразделения в БД
     * входные параметры: полным набором атрибутов подразделения
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PostMapping(path = "/v0/bankUnits")
    public ResponseEntity<BankUnit> newBankUnit(String number, String name, String address, String phoneNumber, String description, String comment, Long parentId, Long typeId) {

        //ниже временный код для проверки работы метода saveBankUnit()
        BankUnit bankUnit = new BankUnit();
        bankUnit.setNumber(number);
        bankUnit.setName(name);
        bankUnit.setAddress(address);
        bankUnit.setPhoneNumber(phoneNumber);
        bankUnit.setDescription(description);
        bankUnit.setComment(comment);
        bankUnit.setParentId(parentId);
        bankUnit.setTypeId(typeId);

        BankUnit bnkUnt;
        try {
            bnkUnt = this.bankUnitService.saveBankUnit(bankUnit);
            return new ResponseEntity<>(bnkUnt, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод сохранения данных подразделения в БД
     * входные параметры: полным набором атрибутов подразделения
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PutMapping(path = "/v0/bankUnits")
    public ResponseEntity<BankUnit> saveBankUnit(long id, String number, String name, String address, String phoneNumber, String description, String comment, Long parentId, Long typeId) {

        //ниже временный код для проверки работы метода saveBankUnit()
        BankUnit bankUnit = new BankUnit();
        bankUnit.setId(id);
        bankUnit.setNumber(number);
        bankUnit.setName(name);
        bankUnit.setAddress(address);
        bankUnit.setPhoneNumber(phoneNumber);
        bankUnit.setDescription(description);
        bankUnit.setComment(comment);
        bankUnit.setParentId(parentId);
        bankUnit.setTypeId(typeId);

        BankUnit bnkUnt;
        try {
            bnkUnt = this.bankUnitService.saveBankUnit(bankUnit);
            return new ResponseEntity<>(bnkUnt, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод получения данных подразделения из БД по id
     * входные параметры: id подразделения
     * выходные параметры: объект типа BankUnit с полным набором атрибутов
     */
    @GetMapping(path = "/v0/bankUnits/{id}")
    public BankUnit getBankUnitById(@PathVariable("id") long id) {
        return this.bankUnitService.getBankUnitByID(id);
    }

    /**
     * Метод удаления подразделения из БД
     * входные параметры: id подразделения
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/v0/bankUnits/{id}")
    public ResponseEntity<BankUnit> deleteBankUnitById(@PathVariable("id") long id) {
        BankUnit bankUnit = getBankUnitById(id);
        try{
            this.bankUnitService.deleteBankUnit(bankUnit);
            return new ResponseEntity<>(null, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
