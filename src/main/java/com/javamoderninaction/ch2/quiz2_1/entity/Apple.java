package com.javamoderninaction.ch2.quiz2_1.entity;

import com.javamoderninaction.ch2.quiz2_1.enums.EAppleColor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Apple {
    private int id;
    private EAppleColor color;
    private double weight;
}
