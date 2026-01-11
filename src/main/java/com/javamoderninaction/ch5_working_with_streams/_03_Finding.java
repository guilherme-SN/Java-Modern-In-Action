package com.javamoderninaction.ch5_working_with_streams;

import com.javamoderninaction.ch5_working_with_streams.entity.Dish;

import java.util.List;

public class _03_Finding {
    public static void main(String[] args) {
        List<Dish> dishes = Dish.defaultDishes();

        allMatchMethod(dishes);
        noneMatchMethod(dishes);
        anyMatchMethod(dishes);
        findFirstMethod(dishes);
        findAnyMethod(dishes);
    }

    private static void allMatchMethod(List<Dish> dishes) {
        boolean isAllDishesVegetarian = dishes.stream()
                .allMatch(Dish::isVegetarian);

        System.out.println("Is all dishes vegetarian?: " + isAllDishesVegetarian);
    }

    private static void noneMatchMethod(List<Dish> dishes) {
        boolean isAllDishesNonVegetarian = dishes.stream()
                .noneMatch(Dish::isVegetarian);

        System.out.println("Is all dishes non-vegetarian?: " + isAllDishesNonVegetarian);
    }

    private static void anyMatchMethod(List<Dish> dishes) {
        boolean anyVegetarianDish = dishes.stream()
                .anyMatch(Dish::isVegetarian);

        System.out.println("Is there any vegetarian dish?: " + anyVegetarianDish);
    }

    private static void findFirstMethod(List<Dish> dishes) {
        dishes.stream()
                .filter(dish -> Dish.EType.MEAT.equals(dish.getType()))
                .findFirst()
                .map(Dish::getName)
                .ifPresent(System.out::println);
    }

    private static void findAnyMethod(List<Dish> dishes) {
        dishes.stream()
                .filter(dish -> Dish.EType.MEAT.equals(dish.getType()))
                .findAny()
                .map(Dish::getName)
                .ifPresent(System.out::println);
    }
}
