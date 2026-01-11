package com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.implementations;

import com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.entity.Apple;
import com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.interfaces.IApplePrinter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class HeavyApplePrinter implements IApplePrinter {
    private static final double HEAVY_THRESHOLD = 50.0;

    @Override
    public String getContent(List<Apple> apples) {
        return apples.stream()
                .filter(apple -> apple.getWeight() >= HEAVY_THRESHOLD)
                .map(apple -> String.format("Maçã %d é pesada: %.2fg", apple.getId(), apple.getWeight()))
                .collect(Collectors.joining("\n"));
    }
}
