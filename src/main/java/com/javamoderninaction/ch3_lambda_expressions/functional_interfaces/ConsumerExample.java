package com.javamoderninaction.ch3_lambda_expressions.functional_interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<User> users = User.defaultUsers();

        Consumer<User> userConsumer = user -> System.out.println("Printando usuário: " + user.getName());

        users.forEach(userConsumer);
    }
}
