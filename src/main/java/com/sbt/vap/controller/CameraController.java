package com.sbt.vap.controller;

import com.sbt.vap.model.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.CameraService;

import java.util.List;


@RestController
@CrossOrigin
public class CameraController {

    @Autowired
    private CameraService cameraService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        //headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех камер из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа Camera с полным набором атрибутов
     */
    @GetMapping(path = "/v0/cameras")
    public List<Camera> getAllCameras() {
        List<Camera> cameraList = this.cameraService.findAll();
        return cameraList;
    }

    /**
     * Метод получения списка камер установленных в выбранном подразделении
     * входные параметры: id подразделения
     * выходные параметры: List объектов типа Camera с полным набором атрибутов у которых id=bankUnitId
     */
    @GetMapping(path = "/v0/bank-units/{bankUnitId}/cameras")
    public ResponseEntity<List<Camera>> getBankUnitCameras(@PathVariable("bankUnitId") Long bankUnitId) {
        List<Camera> cameraList = this.cameraService.findByBankUnit(bankUnitId);
        if(cameraList!=null) {
            return new ResponseEntity<>(cameraList, headers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(cameraList, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод получения данных камеры из БД по id
     * входные параметры: id камеры
     * выходные параметры: объект типа Camera с полным набором атрибутов
     */
    @GetMapping(path = "/v0/cameras/{id}")
    public Camera getCameraById(@PathVariable("id") long id) {
        return this.cameraService.findCameraByID(id);
    }

    /**
     * Метод сохранения данных камеры в БД
     * входные параметры: полным набором атрибутов камеры
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PutMapping(path = "/v0/cameras")
    public ResponseEntity<Camera> saveCamera(Long id, String ipAddress, String name, String model, String vendorName, String description, String comment) {

        //ниже временный код для проверки работы метода saveCamera()
        Camera camera = new Camera();
        camera.setId(id);
        camera.setIPAddress(ipAddress);
        camera.setName(name);
        camera.setModel(model);
        camera.setVendorName(vendorName);
        camera.setDescription(description);
        camera.setComment(comment);

        Camera cam;
        try {
            cam = this.cameraService.saveCamera(camera);
            return new ResponseEntity<>(cam, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод добавления новой камеры в БД
     * входные параметры: полным набором атрибутов камеры (кроме id)
     * выходные параметры: id новой записи в таблице Camera
     */
    @PostMapping(path = "/v0/cameras")
    public ResponseEntity<Camera> newCamera(Long id, String ipAddress, String name, String model, String vendorName, String description, String comment) {

        //ниже временный код для проверки работы метода saveCamera()
        Camera camera = new Camera();
        camera.setIPAddress(ipAddress);
        camera.setName(name);
        camera.setModel(model);
        camera.setVendorName(vendorName);
        camera.setDescription(description);
        camera.setComment(comment);

        Camera cam;
        try {
            cam = this.cameraService.saveCamera(camera);
            return new ResponseEntity<>(cam, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Метод удаления камеры из БД
     * входные параметры: id камеры
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/v0/cameras/{id}")
    public ResponseEntity<Camera> deleteCameraById(@PathVariable("id") long id) {
        Camera camera = getCameraById(id);
        try{
            this.cameraService.deleteCamera(camera);
            return new ResponseEntity<>(null, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Метод запроса видеопотока от выбранной камеры
     * входные параметры: id камеры
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/cameras/{cameraId}/nnModels/{nnMmodelId}/")
    public ResponseEntity<Camera> getCameraVideoById(@PathVariable("cameraId") long id, @PathVariable("nnMmodelId") Long nnMmodelId) {
        Camera camera = getCameraById(id);
        try{
            //this.cameraService.deleteCamera(camera);

            //Сделать вызов REST функции vap-video и передать ей id камеры для формирования видеострима на фронт

            return new ResponseEntity<>(null, headers, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
