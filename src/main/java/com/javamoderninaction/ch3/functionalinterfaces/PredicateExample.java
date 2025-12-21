package com.javamoderninaction.ch3.functionalinterfaces;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<User> users = User.defaultUsers();

        Predicate<User> adultFilter = user -> user.getAge() >= 18;

        List<User> filteredUsers = filterAdults(users, adultFilter);
        System.out.println(filteredUsers);
    }

    private static List<User> filterAdults(List<User> users, Predicate<User> userPredicate) {
        return users.stream()
                .filter(userPredicate)
                .toList();
    }
}
