package com.study.bevarage.api.impl;

import com.study.bevarage.BevarageApplicationIntegrationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
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
        final ResponseEntity entity = beverageApi.getTotalOrderPrice(orders);
        assertEquals(entity.getStatusCode(), HttpStatus.BAD_REQUEST);
      //  assertThrows(Exception.class, () -> beverageApi.getTotalOrderPrice(orders) );
    }
}