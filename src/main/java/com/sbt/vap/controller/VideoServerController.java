package com.sbt.vap.controller;

import com.sbt.vap.model.VideoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.VideoServerService;

import java.util.List;

@RestController
@CrossOrigin
public class VideoServerController {

    @Autowired
    private VideoServerService videoServerService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        //headers.set("Access-Control-Allow-Origin", "*");
    }

    /**
     * Метод получения списка всех видео-серверов из БД
     * входные параметры: нет
     * выходные параметры: List объектов типа VideoServer с полным набором атрибутов
     */
    @GetMapping(path = "/v0/videoServers")
    public List<VideoServer> getAllVideoServers() {
        List<VideoServer> videoServerList = this.videoServerService.findAll();
        return videoServerList;
    }

    /**
     * Метод добавления нового видеосервера в БД
     * входные параметры: полным набором атрибутов видеосервера
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PostMapping(path = "/v0/videoServers")
    public boolean newVideoServer(String vendorName, String model, String ipAddress, String description, String comment) {

        //ниже временный код для проверки работы метода saveVideoServer()
        VideoServer videoServer = new VideoServer();
        videoServer.setVendorName(vendorName);
        videoServer.setModel(model);
        videoServer.setIPAddress(ipAddress);
        videoServer.setDescription(description);
        videoServer.setComment(comment);

        this.videoServerService.saveVideoServer(videoServer);
        return true;
    }

    /**
     * Метод сохранения данных видеосервера в БД
     * входные параметры: полным набором атрибутов видеосервера
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @PutMapping(path = "/v0/videoServers")
    public boolean saveVideoServer(long id, String vendorName, String model, String ipAddress, String description, String comment) {

        //ниже временный код для проверки работы метода saveVideoServer()
        VideoServer videoServer = new VideoServer();
        videoServer.setId(id);
        videoServer.setVendorName(vendorName);
        videoServer.setModel(model);
        videoServer.setIPAddress(ipAddress);
        videoServer.setDescription(description);
        videoServer.setComment(comment);

        this.videoServerService.saveVideoServer(videoServer);
        return true;
    }


    /**
     * Метод получения данных видеосервера из БД по id
     * входные параметры: id видеосервера
     * выходные параметры: объект типа VideoServer с полным набором атрибутов
     */
    @GetMapping(path = "/v0/videoServers/{id}")
    public VideoServer getVideoServerById(@PathVariable("id") Long id) {
        return this.videoServerService.getVideoServerByID(id);
    }

    /**
     * Метод удаления видеосервера из БД
     * входные параметры: id видеосервера
     * выходные параметры: HTTPStatus (200 – нормальное срабатывание, 500 – сбой)
     */
    @DeleteMapping(path = "/v0/videoServers/{id}")
    public boolean deleteVideoServerById(@PathVariable("id") Long id) {
        VideoServer videoServer = getVideoServerById(id);
        this.videoServerService.deleteVideoServer(videoServer);
        return true;
    }


}
