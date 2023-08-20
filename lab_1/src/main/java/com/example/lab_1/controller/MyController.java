package com.example.lab_1.controller;

import com.example.lab_1.model.Request;
import com.example.lab_1.model.Responce;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class MyController {

    @PostMapping(value = "/feedback")
    public ResponseEntity<Responce> feedback(@RequestBody Request request) {
        Responce response = Responce.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemName())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
