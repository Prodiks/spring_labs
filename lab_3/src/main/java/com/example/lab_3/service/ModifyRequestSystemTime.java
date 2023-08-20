package com.example.lab_3.service;

import com.example.lab_3.model.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService {
    @Override
    public void modifyRequest(Request request){
        request.setSystemTime("testing time");

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8080/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<> (){});

    }
}
