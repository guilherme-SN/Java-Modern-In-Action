package com.javamoderninaction.ch5;

import java.util.List;
import java.util.function.Predicate;

public class Filtering {
    public static void main(String[] args) {
        List<Dish> dishes = Dish.defaultDishes();

        Predicate<Dish> isVegetarianPredicate = Dish::isVegetarian;

        List<Dish> vegetarianDishes = dishes.stream()
                .filter(isVegetarianPredicate)      // filter() espera um Predicate
                .toList();

        List<Integer> distinctCalories = dishes.stream()
                .map(Dish::getCalories)
                .distinct()     // Retorna apenas as calorias distintas
                .toList();

        System.out.println("Vegetarian dishes: " + vegetarianDishes);
        System.out.println("Distinct calories: " + distinctCalories);
    }
}
