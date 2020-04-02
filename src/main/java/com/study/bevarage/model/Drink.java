package com.study.bevarage.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "DRINK")
@Data
public class Drink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Drink_Id")
    private Long id;

    @Column(name = "Drink_Type")
    private String drinkType;

    @Column(name = "Drink_Price")
    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DRINK_INGREDIENTS", joinColumns = @JoinColumn (name= "Drink_Id"),
            inverseJoinColumns = @JoinColumn(name = "Ingredient_Id") )
    private List<Ingredient> ingredients;

}
