package com.javamoderninaction.ch2.quiz2_1.interfaces;

import com.javamoderninaction.ch2.quiz2_1.entity.Apple;

import java.util.List;

public interface IApplePrinter {
    String getContent(List<Apple> apples);
}
