package com.incubyte;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        return calculateSum(numbers.split(","));
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }


}
