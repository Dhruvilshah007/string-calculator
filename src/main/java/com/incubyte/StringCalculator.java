package com.incubyte;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        return calculateSum(numbers.split(delimiter));
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }


}
