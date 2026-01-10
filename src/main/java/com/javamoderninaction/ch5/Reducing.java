package com.javamoderninaction.ch5;

import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        List<Dish> dishes = Dish.defaultDishes();

        sumCalories(dishes);
        maxCaloriesValue(dishes);
    }

    private static void sumCalories(List<Dish> dishes) {
        int sum = dishes.stream()
                .map(Dish::getCalories)
                //.reduce(0, (a, b) -> a + b);      // Passando a função lambda
                .reduce(0, Integer::sum);   // Passando a referência do método sum()

        Optional<Integer> sumOptional = dishes.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum);      // Retorna um Optional para o caso da Stream não ter elementos

        System.out.println("Total calories: " + sum);
        sumOptional.ifPresent(total -> System.out.println("Total (optional): " + total));
    }

    private static void maxCaloriesValue(List<Dish> dishes) {
        int max = dishes.stream()
                .map(Dish::getCalories)
                .reduce(Integer::max)
                .orElse(0);

        System.out.println("Max calories value: " + max);
    }
}
