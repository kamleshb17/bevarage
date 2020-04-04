package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageFactoryApplicationIntegrationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class OrderServiceImplTest extends BevarageFactoryApplicationIntegrationTests {

    private OrderServiceImpl orderService;

    @Autowired
    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Test
    public void getOrders() {
        final String[] orders = {"Coffee"};
        final List<Map<String, String[]>> orderMap= orderService.getOrders(orders);
        final Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("Coffee", new String[]{"coffee"});
        final List<Map<String, String[]>> expectedOrderMap = new ArrayList<Map<String, String[]>>();
        expectedOrderMap.add(map);
        assertNotNull(orderMap);
        assertEquals(orderMap.get(0).containsKey("Coffee"), expectedOrderMap.get(0).containsKey("Coffee"));
    }
}