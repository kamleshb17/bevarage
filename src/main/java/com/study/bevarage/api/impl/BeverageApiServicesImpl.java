package com.study.bevarage.api.impl;

import com.study.bevarage.api.BevarageApiServices;
import org.springframework.http.ResponseEntity;

public abstract class BeverageApiServicesImpl implements BevarageApiServices {
    public abstract ResponseEntity getTotalOrderPrice(final String[] orders);
}
