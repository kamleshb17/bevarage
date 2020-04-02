package com.study.bevarage.api.impl;

import com.study.bevarage.BevarageApplicationIntegrationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class BeverageApiImplTest extends BevarageApplicationIntegrationTests {

    private BeverageApiImpl beverageApi;

    @Autowired
    public void setBeverageApi(BeverageApiImpl beverageApi) {
        this.beverageApi = beverageApi;
    }

    @Test
    public void test_GetTotalOrderPriceForSingleOrder() {
        final String[] orders = {"Coffee"};
        final ResponseEntity entity = beverageApi.getTotalOrderPrice(orders);
        assertNotNull(entity);
        assertEquals(entity.getBody(), 5.00);
    }

    @Test
    public void test_GetTotalOrderPriceForMultipleOrder() {
        final String[] orders = {"Coffee", "Chai, -sugar, -milk"};
        final ResponseEntity entity = beverageApi.getTotalOrderPrice(orders);
        assertNotNull(entity);
        assertEquals(entity.getBody(), 9.00);
    }

    @Test
    public void test_GetTotalOrderPriceForNoOrder() {
        final String[] orders = null;
        assertThrows(Exception.class, () -> beverageApi.getTotalOrderPrice(orders) );
    }
}