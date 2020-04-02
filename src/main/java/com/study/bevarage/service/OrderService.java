package com.study.bevarage.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    List<Map<String, String[]>> getOrders(String[] orders);
}
