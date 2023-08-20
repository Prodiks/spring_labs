package com.example.lab_3.controller;

import com.example.lab_3.model.Request;
import com.example.lab_3.model.Responce;
import com.example.lab_3.service.ModifyRequestService;
import com.example.lab_3.service.MyModifyService;
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
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService, ModifyRequestService modifyRequestService) {
        this.myModifyService = myModifyService;
        this.modifyRequestService = modifyRequestService;
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

        modifyRequestService.modifyRequest(request);

        Responce modifyedResponce = myModifyService.modify(response);
        log.info("МОДИФИЦИРОВАННЫЙ: " + String.valueOf(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
