package com.sbt.vap.controller;

import com.sbt.vap.model.BankUnit;
import com.sbt.vap.model.NNModelDTO;
import com.sbt.vap.model.User;
import com.sbt.vap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import com.sbt.vap.model.NNModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.NNModelService;

import java.util.List;

@RestController
@CrossOrigin
public class NNModelController {

    @Autowired
    private NNModelService nnModelService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
//        headers.set("Access-Control-Allow-Origin", "*");
//        headers.set("Access-Control-Allow-Methods", "POST, GET");
//        headers.set("Access-Control-Max-Age", "7200");
//        headers.set("Access-Control-Allow-Headers", "x-requested-with");
    }

    /**
     * Метод получения списка всех моделей из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа NNModel с полным набором атрибутов
     */
    @GetMapping(path = "/v0/nnModels")
    public List<NNModel> getAllNNModels() {
        List<NNModel> nnModelList = this.nnModelService.findAll();
        return nnModelList;
    }

    /**
     * Метод добавления новой модели в БД
     * входные параметры: полным набором атрибутов модели (кроме id)
     * выходные параметры: id новойзаписи в таблице CAMERA
     */
    @PostMapping(path = "/v0/nnModels")
    @ResponseBody
    public Long newNNModel(@RequestBody NNModelDTO body) {

        //ниже временный код для проверки работы метода saveNNModel()
        NNModel nnModel = new NNModel();
        nnModel.setName(body.getName());
        nnModel.setSystemName(body.getSystemName());
        nnModel.setActivity(body.getActivity());

        NNModel nnMdl = this.nnModelService.saveNNModel(nnModel);
        return nnMdl.getId();
    }

    /**
     * Метод сохранения данных модели в БД
     * входные параметры: полным набором атрибутов модели
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PutMapping(path = "/v0/nnModels")
    @ResponseBody
    public ResponseEntity<NNModel> saveNNModel(@RequestBody NNModel body) {

        NNModel nnMd1;
        try{
            nnMd1 = this.nnModelService.saveNNModel(body);
            return new ResponseEntity<>(nnMd1, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод получения данных модели из БД по id
     * входные параметры: id модели
     * выходные параметры: объект типа NNModel с полным набором атрибутов
     */
    @GetMapping(path = "/v0/nnModels/{id}")
    public NNModel getNNModelById(@PathVariable("id") long id) {
        NNModel nnModel = this.nnModelService.getNNModelByID(id);
        return nnModel;
    }

    /**
     * Метод удаления модели из БД
     * входные параметры: id модели
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/v0/nnModels/{id}")
    public Boolean deleteCameraById(@PathVariable("id") long id) {
        NNModel nnModel = getNNModelById(id);
        this.nnModelService.deleteNNModel(nnModel);
        try{
            this.nnModelService.deleteNNModel(nnModel);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


}
