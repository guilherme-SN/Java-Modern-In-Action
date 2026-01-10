package com.javamoderninaction.ch5.quiz;

import java.util.Arrays;
import java.util.List;

public class Quiz5_2 {
    public static void main(String[] args) {
        // 2. Given two lists of numbers, how would you return all pairs of numbers? For example,
        // given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4),
        // (3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4);

        List<int[]> pairs = list1.stream()
                .flatMap(i ->       // Se fosse .map(), retornaria uma Stream<Stream<int[]>>
                        list2.stream()
                                .map(j -> new int[]{i, j})
                )
                .toList();

        System.out.println("All pairs:");
        pairs.forEach(pair -> System.out.print(Arrays.toString(pair) + " "));

        // How would you extend the previous example to return only pairs whose sum is divisible by 3?
        List<int[]> pairsDivisibleBy3 = pairs.stream()
                .filter(Quiz5_2::isSumDivisibleBy3)
                .toList();

        System.out.println();
        System.out.println("All pairs divisible by 3:");
        pairsDivisibleBy3.forEach(pair -> System.out.print(Arrays.toString(pair) + " "));

        // Outra solução seria fazer um filter() dentro do flatMap()
    }

    private static boolean isSumDivisibleBy3(int[] pair) {
        return (pair[0] + pair[1]) % 3 == 0;
    }
}
