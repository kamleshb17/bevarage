package com.study.bevarage.service;

import org.springframework.stereotype.Service;

public interface BussinessService {
    Double getTotalOrderPrice(final String[] orders);
}
