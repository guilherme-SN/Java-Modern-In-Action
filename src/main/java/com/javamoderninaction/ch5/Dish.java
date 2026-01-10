package com.javamoderninaction.ch5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private boolean isVegetarian;
    private int calories;
    private EType type;

    public static List<Dish> defaultDishes() {
        return List.of(
                new Dish("Dish 1", true, 100, EType.MEAT),
                new Dish("Dish 2", false, 200, EType.FISH),
                new Dish("Dish 3", false, 300, EType.FISH),
                new Dish("Dish 4", true, 500, EType.FISH),
                new Dish("Dish 5", false, 50, EType.OTHER),
                new Dish("Dish 6", true, 150, EType.OTHER),
                new Dish("Dish 7", true, 700, EType.MEAT),
                new Dish("Dish 8", false, 20, EType.MEAT)
        );
    }

    public enum EType {
        MEAT,
        FISH,
        OTHER
    }
}
