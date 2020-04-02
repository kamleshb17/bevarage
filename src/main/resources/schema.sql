DROP TABLE IF EXISTS DRINK;


CREATE TABLE DRINK (
  Drink_Id INT(11)  PRIMARY KEY,
  Drink_Type VARCHAR(250) NOT NULL,
  Drink_Price Number(3, 2) NOT NULL

);

DROP TABLE IF EXISTS INGREDIENT;

CREATE TABLE INGREDIENT (
  Ingredient_Id INT(11) PRIMARY KEY,
  Ingredient_Type VARCHAR(250) NOT NULL,
  Ingredient_Price Number(3, 2) NOT NULL

);

DROP TABLE IF EXISTS DRINK_INGREDIENTS;
CREATE TABLE DRINK_INGREDIENTS (
 Drink_Ingredient_Id INT(11) AUTO_INCREMENT PRIMARY KEY,
  Drink_Id INT(11) NOT NULL,
  Ingredient_Id INT(11) NOT NULL

);