package com.javamoderninaction.ch2.quiz2_1;

import com.javamoderninaction.ch2.quiz2_1.entity.Apple;
import com.javamoderninaction.ch2.quiz2_1.enums.EAppleColor;
import com.javamoderninaction.ch2.quiz2_1.implementations.AppleWeightPrinter;
import com.javamoderninaction.ch2.quiz2_1.implementations.HeavyApplePrinter;
import com.javamoderninaction.ch2.quiz2_1.service.AppleService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AppleWeightPrinter appleWeightPrinter = new AppleWeightPrinter();
        HeavyApplePrinter heavyApplePrinter= new HeavyApplePrinter();
        AppleService appleService = new AppleService();

        List<Apple> apples = List.of(
                new Apple(1, EAppleColor.GREEN, 60.0),
                new Apple(2, EAppleColor.RED, 40.0),
                new Apple(3, EAppleColor.GREEN, 20.0),
                new Apple(4, EAppleColor.RED, 80.0),
                new Apple(5, EAppleColor.GREEN, 70.0)
        );

        System.out.println("Printando o peso das maçãs:");
        appleService.prettyPrint(apples, appleWeightPrinter);

        System.out.println("Printando as maçãs pesadas:");
        appleService.prettyPrint(apples, heavyApplePrinter);
    }
}
