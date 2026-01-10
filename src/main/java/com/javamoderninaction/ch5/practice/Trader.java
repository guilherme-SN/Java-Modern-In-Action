package com.javamoderninaction.ch5.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;
}
