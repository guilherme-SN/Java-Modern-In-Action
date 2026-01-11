package com.javamoderninaction.ch5_working_with_streams.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.defaultTransactions();
        question1(transactions);
        question2(transactions);
        question3(transactions);
        question4(transactions);
        question5(transactions);
        question6(transactions);
        question7(transactions);
        question8(transactions);
    }

    // 1 Find all transactions in the year 2011 and sort them by value (small to high).
    private static void question1(List<Transaction> transactions) {
        List<Transaction> answer = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        System.out.println("Question 1:");
        System.out.println(answer);
    }

    // 2 What are all the unique cities where the traders work?
    private static void question2(List<Transaction> transactions) {
        List<String> answer = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .toList();

        System.out.println("Question 2:");
        System.out.println(answer);
    }

    // 3 Find all traders from Cambridge and sort them by name.
    private static void question3(List<Transaction> transactions) {
        List<Trader> answer = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

        System.out.println("Question 3:");
        System.out.println(answer);
    }

    // 4 Return a string of all traders’ names sorted alphabetically.
    private static void question4(List<Transaction> transactions) {
        List<String> answer = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .toList();

        System.out.println("Question 4:");
        System.out.println(answer);
    }

    // 5 Are any traders based in Milan?
    private static void question5(List<Transaction> transactions) {
        boolean answer = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch("Milan"::equals);

        System.out.println("Question 5:");
        System.out.println(answer);
    }

    // 6 Print the values of all transactions from the traders living in Cambridge.
    private static void question6(List<Transaction> transactions) {
        List<Integer> answer = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .toList();

        System.out.println("Question 6:");
        System.out.println(answer);
    }

    // 7 What’s the highest value of all the transactions?
    private static void question7(List<Transaction> transactions) {
        int answer = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(-1);

        System.out.println("Question 7:");
        System.out.println(answer);
    }

    // 8 Find the transaction with the smallest value.
    private static void question8(List<Transaction> transactions) {
        Optional<Transaction> answer = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));

        if (answer.isEmpty()) return;

        System.out.println("Question 8:");
        System.out.println(answer.get());
    }
}
