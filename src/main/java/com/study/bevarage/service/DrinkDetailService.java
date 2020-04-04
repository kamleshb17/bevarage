package com.study.bevarage.service;

import com.study.bevarage.model.Drink;
import com.study.bevarage.repository.DrinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrinkDetailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String, Drink> drinkMap;
    private DrinkRepository drinkRepository;

    public Map<String, Drink> getDrinkMap() {
        return drinkMap;
    }

    public void setDrinkMap(Map<String, Drink> drinkMap) {
        this.drinkMap = drinkMap;
    }

    @Cacheable("drinkMap")
    @EventListener(ApplicationReadyEvent.class)
    public void getDrinkPrice() {
        logger.info("{} getDrinkPrice in action ", this.getClass());
        final List<Drink> drinks = drinkRepository.findAll();
        this.drinkMap = new HashMap<>();
        drinks.forEach(drink -> {
            this.drinkMap.put(drink.getDrinkName(), drink);
        });
        logger.info("{} getDrinkPrice action completed", this.getClass());
    }

    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

}
