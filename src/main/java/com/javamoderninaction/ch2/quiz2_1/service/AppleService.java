package com.javamoderninaction.ch2.quiz2_1.service;

import com.javamoderninaction.ch2.quiz2_1.entity.Apple;
import com.javamoderninaction.ch2.quiz2_1.interfaces.IApplePrinter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AppleService {
    public void prettyPrint(List<Apple> apples, IApplePrinter applePrinter) {
        System.out.println(applePrinter.getContent(apples));
    }
}
