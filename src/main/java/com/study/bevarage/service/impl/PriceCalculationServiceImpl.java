package com.study.bevarage.service.impl;

import com.study.bevarage.model.Drink;
import com.study.bevarage.model.Ingredient;
import com.study.bevarage.service.DrinkDetailService;
import com.study.bevarage.service.PriceCalculationService;
import com.study.bevarage.utility.BevarageUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceCalculationServiceImpl implements PriceCalculationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private DrinkDetailService drinkDetailService;

    @Autowired
    public void setDrinkDetailService(DrinkDetailService drinkDetailService) {
        this.drinkDetailService = drinkDetailService;
    }

    @Override
    public Double getTotalOrderPrice(final Map<String, String[]> map) {
        logger.info(" {} getTotalOrderPrice in action ", this.getClass());
        Double price = 0.0;

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            final Drink drink = drinkDetailService.getDrinkMap().get(entry.getKey());
            logger.info("drink loaded from drinkmap {}", drink);
            price = drink.getPrice();

            final List<String> orderedIngredients = Arrays.stream(entry.getValue()).map(BevarageUtility :: getValue).collect(Collectors.toList());

            double unOrderPrice = drink.getIngredients().stream().filter(ingredients -> orderedIngredients.stream().anyMatch( orderedIngredient ->
                    !orderedIngredient.equalsIgnoreCase(entry.getKey()) && !orderedIngredients.contains( ingredients.getIngredientName().toLowerCase()))).collect(Collectors.summingDouble(Ingredient::getPrice));

            price = price - unOrderPrice;


        }
        logger.info(" {} getTotalOrderPrice action completed with price {}", this.getClass(), price);
        return price;
    }

}
