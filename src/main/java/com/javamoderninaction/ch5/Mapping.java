package com.javamoderninaction.ch5;

import java.util.Arrays;
import java.util.List;

public class Mapping {
    public static void main(String[] args) {
        List<Dish> dishes = Dish.defaultDishes();

        mapMethod(dishes);
        flatMapMethod();
    }

    private static void mapMethod(List<Dish> dishes) {
        List<String> dishesName = dishes.stream()
                .map(Dish::getName)
                .toList();

        System.out.println("Dishes name: " + dishesName);
    }

    private static void flatMapMethod() {
        List<String> words = List.of("Hello", "World");

        // Suponha que queremos pegar todas as letras distintas dessa lista
        // Tentativa 1:
//        List<String> distinctLetters1 = words.stream()
//                .map(word -> word.split(""))    <-- aqui retorna um Stream<String[]> (problema)
//                .distinct()
//                .toList();

        // Tentativa 2:
//        List<String> distinctLetters2 = words.stream()
//                .map(word -> word.split(""))
//                .map(Arrays::stream)      <-- aqui retorna um Stream<Stream<String>> (ainda errado)
//                .distinct()
//                .toList();    <-- Retorna List<Stream<String>>

        // Tentativa 3:
        List<String> distinctLetters3 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)    // <-- transforma o Stream<String[]> para Stream<String>
                .distinct()                 // Ou seja, pega o conteúdo dos arrays e joga numa Stream única
                .toList();

        System.out.println("Distinct letters: " + distinctLetters3);
    }
}
