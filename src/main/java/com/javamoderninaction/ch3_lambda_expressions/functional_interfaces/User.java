package com.javamoderninaction.ch3_lambda_expressions.functional_interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;

    public static List<User> defaultUsers() {
        return  List.of(
                new User(1, "Guilherme", 22),
                new User(2, "João", 18),
                new User(3, "Maria", 26),
                new User(4, "Lucas", 16),
                new User(5, "Pedro", 14)
        );
    }
}
