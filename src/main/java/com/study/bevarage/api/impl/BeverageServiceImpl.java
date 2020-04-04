package com.study.bevarage.api.impl;

import com.study.bevarage.service.BussinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BeverageServiceImpl extends BeverageApiServicesImpl {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private BussinessService bussinessService;

    @Autowired
    public void setBussinessService(BussinessService bussinessService) {
        this.bussinessService = bussinessService;
    }

    @Override
    public ResponseEntity getTotalOrderPrice(final String[] orders) {
        logger.info("{} getTotalOrderPrice started wih order ", this.getClass(), orders);
        ResponseEntity entity = null;

        if (ObjectUtils.isEmpty(orders)) {
            entity = new ResponseEntity(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            try {
                final Double price = bussinessService.getTotalOrderPrice(orders);
                entity = new ResponseEntity(price, HttpStatus.OK);
            } catch (Exception e) {
                entity = new ResponseEntity(HttpStatus.EXPECTATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
                logger.error(" {} getTotalOrderPrice exception {} ", this.getClass(), e);
            }
        }
        logger.info("{} getTotalOrderPrice completed ", this.getClass());
        return entity;
    }
}
