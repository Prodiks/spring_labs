package com.example.lab_2.controller;

import com.example.lab_2.model.Request;
import com.example.lab_2.model.Responce;
import com.example.lab_2.service.MyModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
public class MyController {
    private final MyModifyService myModifyService;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Responce> feedback(@RequestBody Request request) {
        log.info("ПОЛУЧЕН ЗАПРОС: " + String.valueOf(request));

        Responce response = Responce.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemName())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        Responce modifyedResponce = myModifyService.modify(response);
        log.info("МОДИФИЦИРОВАННЫЙ: " + String.valueOf(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
