package com.study.bevarage.service.impl;

import com.study.bevarage.BevarageApplicationIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceImplTest extends BevarageApplicationIntegrationTests {

    private OrderServiceImpl orderService;

    @Autowired
    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Test
    void getOrders() {
        final String[] orders = {"Coffee"};
        final List<Map<String, String[]>> orderMap= orderService.getOrders(orders);
        final Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("Coffee", null);
        final List<Map<String, String[]>> expectedOrderMap = new ArrayList<Map<String, String[]>>();
        expectedOrderMap.add(map);
        assertNotNull(orderMap);
        assertEquals(orderMap, expectedOrderMap);
    }
}