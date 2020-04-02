package com.study.bevarage.service;

import org.springframework.stereotype.Service;

public interface ApiService {
    public Double getTotalOrderPrice(final String[] orders);
}
