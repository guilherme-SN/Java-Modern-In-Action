package com.javamoderninaction.ch5_working_with_streams;

import com.javamoderninaction.ch5_working_with_streams.entity.Dish;

import java.util.List;
import java.util.function.Predicate;

public class _01_Filtering {
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
