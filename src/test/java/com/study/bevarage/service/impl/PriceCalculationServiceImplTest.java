package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageApplicationIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCalculationServiceImplTest extends BevarageApplicationIntegrationTests {

    private PriceCalculationServiceImpl priceCalculationService;

    @Autowired
    public void setPriceCalculationService(PriceCalculationServiceImpl priceCalculationService) {
        this.priceCalculationService = priceCalculationService;
    }

    @Test
    public void getTotalOrderPrice() {
        final Map<String, String[]> expectedOrderMap = new HashMap<String, String[]>();
        expectedOrderMap.put("Coffee", null);

        final Double price = priceCalculationService.getTotalOrderPrice(expectedOrderMap);
        assertEquals(price, 5.00);
    }
}