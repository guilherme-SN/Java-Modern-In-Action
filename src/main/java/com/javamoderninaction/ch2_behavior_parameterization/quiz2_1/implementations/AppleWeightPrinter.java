package com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.implementations;

import com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.entity.Apple;
import com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.interfaces.IApplePrinter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class AppleWeightPrinter implements IApplePrinter {
    @Override
    public String getContent(List<Apple> apples) {
        return apples.stream()
                .map(Apple::getWeight)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
