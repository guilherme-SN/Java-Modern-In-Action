package com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.interfaces;

import com.javamoderninaction.ch2_behavior_parameterization.quiz2_1.entity.Apple;

import java.util.List;

public interface IApplePrinter {
    String getContent(List<Apple> apples);
}
