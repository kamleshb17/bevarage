package com.study.bevarage.service.impl;

import com.study.bevarage.model.Drink;
import com.study.bevarage.model.Ingredient;
import com.study.bevarage.repository.DrinkRepository;
import com.study.bevarage.service.PriceCalculationService;
import com.study.bevarage.utility.BevarageUtility;
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
import java.util.stream.Collectors;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private DrinkRepository drinkRepository;
    private Map<String, Drink> drinkMap;

    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Map<String, Drink> getDrinkMap() {
        return drinkMap;
    }

    public void setDrinkMap(Map<String, Drink> drinkMap) {
        this.drinkMap = drinkMap;
    }

    @Override
    public Double getTotalOrderPrice(final Map<String, String[]> map) {
        logger.info(" {} getTotalOrderPrice in action ", this.getClass());
        Double price = 0.0;

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            final Drink drink = drinkMap.get(entry.getKey());
            logger.info("drink loaded from drinkmap {}", drink);
            price = drink.getPrice();
            final List<Ingredient> ingredients = drink.getIngredients();
            final List<String> ingredientTypes = ingredients.stream().map(Ingredient::getIngredientType).collect(Collectors.toList());

            for (Ingredient ingredient : ingredients) {
                for (String value : entry.getValue()) {
                    if (!value.equalsIgnoreCase(entry.getKey()) && !ingredientTypes.stream().anyMatch(BevarageUtility.getValue(value)::equalsIgnoreCase)) {
                        price = price - ingredient.getPrice();
                    }
                }
            }

        }
        logger.info(" {} getTotalOrderPrice action completed with price {}", this.getClass(), price);
        return price;
    }

    @Cacheable
    @EventListener(ApplicationReadyEvent.class)
    public void GetDrinkPrice() {
        final List<Drink> drinks = drinkRepository.findAll();
        drinkMap = new HashMap<>();
        drinks.forEach(drink -> {
            drinkMap.put(drink.getDrinkType(), drink);
        });
    }
}
