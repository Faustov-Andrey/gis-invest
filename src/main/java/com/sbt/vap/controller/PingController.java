package com.sbt.vap.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class PingController {

//    private static final HttpHeaders headers = new HttpHeaders();
//
//    static {
//        headers.set("Access-Control-Allow-Origin", "*");
//    }

    @RequestMapping("/ping")
    public String ping() {
        return "!!!PING_SUCCESS!!!";
    }

}
