package com.study.bevarage.service.impl;

import com.study.bevarage.service.ApiService;
import com.study.bevarage.service.OrderService;
import com.study.bevarage.service.PriceCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiServiceImpl implements ApiService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private OrderService orderService;
    private PriceCalculationService priceCalculationService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setPriceCalculationService(PriceCalculationService priceCalculationService) {
        this.priceCalculationService = priceCalculationService;
    }

    @Override
    public Double getTotalOrderPrice(String[] orders) {
        logger.info(" {} getTotalOrderPrice in action ", this.getClass());
        final List<Map<String, String[]>> orderMapList = orderService.getOrders(orders);
        final Double orderPrice = orderMapList.stream().map(map -> priceCalculationService.getTotalOrderPrice(map))
                .collect(Collectors.summingDouble(Double :: doubleValue));

        logger.info(" {} getTotalOrderPrice completed ", this.getClass());
        return orderPrice;
    }
}
