package com.study.bevarage.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PriceCalculationService {
    Double getTotalOrderPrice(Map<String, String[]> map);
}
