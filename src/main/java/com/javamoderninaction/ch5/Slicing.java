package com.javamoderninaction.ch5;

import java.util.List;

public class Slicing {
    public static void main(String[] args) {
        List<Dish> specialMenu = List.of(
                new Dish("seasonal fruit", true, 120, Dish.EType.OTHER),
                new Dish("prawns", false, 300, Dish.EType.FISH),
                new Dish("rice", true, 350, Dish.EType.OTHER),
                new Dish("chicken", false, 400, Dish.EType.MEAT),
                new Dish("french fries", true, 530, Dish.EType.OTHER)
        );

        takeWhileMethod(specialMenu);
        dropWhileMethod(specialMenu);
        limitMethod(specialMenu);
    }

    private static void takeWhileMethod(List<Dish> specialMenu) {
        // Filtrando pelos pratos com menos de 320 calorias
        // Forma 1: usando o filter()
        specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();

        // Otimização: como a lista está ordenada por caloria, depois que passar dos 320, não precisa continuar
        // Forma 2: usando takeWhile()
        List<Dish> filteredDishes = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320) // enquanto for verdade, continua o processamento
                .toList();

        System.out.println("LT 320 calories: " + filteredDishes);
    }

    private static void dropWhileMethod(List<Dish> specialMenu) {
        // E se fosse o contrário? Filtrar por pratos com mais de 320 calorias
        // Usar dropWhile()
        List<Dish> filteredDishes2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320) // enquanto for verdade, "pula" esses pratos
                .toList();

        System.out.println("GTE 320 calories: " + filteredDishes2);
    }

    private static void limitMethod(List<Dish> specialMenu) {
        List<Dish> filteredDishes3 = specialMenu.stream()
                .filter(dish -> dish.getCalories() >= 300)
                .limit(3)   // Assim que atingir os 3 elementos, ele para de processar a Stream
                .toList();

        System.out.println("First 3 dishes with calories GTE 300: " + filteredDishes3);
    }
}
