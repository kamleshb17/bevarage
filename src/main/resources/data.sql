INSERT INTO DRINK (Drink_Id, Drink_Name, Drink_Price) VALUES
  (1, 'Chai', 4.50),
  (2, 'Coffee', 5.00),
  (3, 'Banana Smoothie', 6.00),
  (4, 'Strawberry Shake', 7.00),
  (5, 'Mojito', 7.50);

INSERT INTO INGREDIENT (Ingredient_Id, Ingredient_Name, Ingredient_Price) VALUES
  (1, 'Milk', 1.00),
  (2, 'Sugar', 0.50),
  (3, 'Soda', 0.50),
  (4, 'mint', 0.50),
  (5, 'water', 0.50);


INSERT INTO DRINK_INGREDIENTS (Drink_Id, Ingredient_Id) VALUES
(1, 1), (1, 2), (1, 5),
(2, 1), (2, 2), (2, 5),
(3, 1), (3, 2), (3, 5),
(4, 1), (4, 2), (4, 5),
(5, 2), (5, 5), (5, 3), (5, 4);