package com.study.bevarage.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INGREDIENT")
@Data
public class Ingredient implements Serializable {
    @Id
    @Column(name = "Ingredient_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Ingredient_Type")
    private String ingredientType;
    @Column(name = "Ingredient_Price")
    private double price;
}
