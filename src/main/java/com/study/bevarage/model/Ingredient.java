package com.study.bevarage.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INGREDIENT")
@Data
@NoArgsConstructor
public class Ingredient implements Serializable {
    @Id
    @Column(name = "Ingredient_Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Ingredient_Name")
    private String ingredientName;
    @Column(name = "Ingredient_Price")
    private double price;
}
