package com.example.lab_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.lab_2.model.Responce;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyModifyService {

    @Override
    public Responce modify(Responce responce) {
        responce.setUid("New uid");
        return responce;
    }

}
