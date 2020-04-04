package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageFactoryApplicationIntegrationTests;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class BussinessServiceImplTest extends BevarageFactoryApplicationIntegrationTests {

    private BussinessServiceImpl apiService;

    @Autowired
    public void setApiService(BussinessServiceImpl apiService) {
        this.apiService = apiService;
    }

    @Test
    public void getTotalOrderPrice() {
        final String[] orders = {"Coffee"};
        final Double price = apiService.getTotalOrderPrice(orders);
        assertNotNull(price);
        assertEquals(price, 5.00);
    }
}