package com.study.bevarage.api.impl;

import com.study.bevarage.api.BevarageApi;
import com.study.bevarage.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class BeverageApiImpl implements BevarageApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApiService apiService;

    @Autowired
    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public ResponseEntity getTotalOrderPrice(@NotNull String[] orders) {
        logger.info("{} getTotalOrderPrice started wih order ", this.getClass(), orders );
        ResponseEntity entity = null;
        try {
            final Double price = apiService.getTotalOrderPrice(orders);
            entity = new ResponseEntity(price, HttpStatus.OK);
        }catch (Exception e){
            entity = new ResponseEntity(HttpStatus.EXPECTATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
            logger.error(" {} getTotalOrderPrice exception {} ", this.getClass() , e);
        }

        logger.info("{} getTotalOrderPrice completed ", this.getClass() );
       return entity;
    }
}
