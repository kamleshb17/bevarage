package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageApplicationIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceImplTest extends BevarageApplicationIntegrationTests {

    private ApiServiceImpl apiService;

    @Autowired
    public void setApiService(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @Test
    void getTotalOrderPrice() {
        final String[] orders = {"Coffee"};
        final Double price = apiService.getTotalOrderPrice(orders);
        assertNotNull(price);
        assertEquals(price, 5.00);
    }
}