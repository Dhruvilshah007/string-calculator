package com.incubyte;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        //default delimiter
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
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.add(num);
            }else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negativeNumbers.isEmpty()) {

            StringBuilder messageBuilder = new StringBuilder("negative numbers not allowed: ");
            for (int negNumber : negativeNumbers) {
                messageBuilder.append(negNumber).append(", ");
            }

            // Remove the trailing comma and space
            messageBuilder.setLength(messageBuilder.length() - 2);
            throw new IllegalArgumentException(messageBuilder.toString());
        }

        return sum;
    }


}
