package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageFactoryApplicationIntegrationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class PriceCalculationServiceImplTest extends BevarageFactoryApplicationIntegrationTests {

    private PriceCalculationServiceImpl priceCalculationService;

    @Autowired
    public void setPriceCalculationService(PriceCalculationServiceImpl priceCalculationService) {
        this.priceCalculationService = priceCalculationService;
    }

    @Test
    public void getTotalOrderPrice() {
        final Map<String, String[]> expectedOrderMap = new HashMap<String, String[]>();
        expectedOrderMap.put("Coffee", new String[]{"coffee"});

        final Double price = priceCalculationService.getTotalOrderPrice(expectedOrderMap);
        assertEquals(5.00, price);
    }
}