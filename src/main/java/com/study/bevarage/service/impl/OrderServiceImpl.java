package com.study.bevarage.service.impl;

import com.study.bevarage.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String COMMA = ",";

    @Override
    public List<Map<String, String[]>> getOrders(final String[] orders) {
        logger.info(" {} getOrders in action ", this.getClass());
        final List<CompletableFuture<Map<String, String[]>>> futures = Arrays.stream(orders).map(this::getAllOrder).collect(Collectors.toList());
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private CompletableFuture<Map<String, String[]>> getAllOrder(final String order) {
        logger.info(" {} getAllOrder in action with order {}", this.getClass(), order);
        return CompletableFuture.supplyAsync(() -> {
            return getOrderMap(order);
        });

    }

    private Map<String, String[]> getOrderMap(final String order) {
        logger.info(" {} getOrderMap in action ", this.getClass());
        final Map<String, String[]> orderMap = Stream.of(order).map(str -> str.split(COMMA)).collect(Collectors.toMap(str -> str[0],
                Function.identity()));
        logger.info(" {} getOrderMap action completed {}", this.getClass(), orderMap);
        return orderMap;
    }
}
