package com.javamoderninaction.ch3.functionalinterfaces;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<User> users = User.defaultUsers();

        Function<User, Integer> getAgeFunction = User::getAge;

        List<Integer> ages = function(users, getAgeFunction);
        System.out.println(ages);
    }

    private static List<Integer> function(List<User> users, Function<User, Integer> userFunction) {
        return users.stream()
                .map(userFunction)
                .toList();
    }
}
