package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        //default delimiter
        String delimiter = ",|\n";
        String[] numArr;

        if (numbers.startsWith("//")) {
            // If numbers starts with //

            int lineEnd = numbers.indexOf('\n');
            String delimiterStr = numbers.substring(2, lineEnd);

            String numberStr = numbers.substring(lineEnd + 1);
            String[] delimArr = delimiterStr.split("\\]\\[");
            int delimLen = delimArr.length;

            String firstDelim = delimArr[0];
            delimArr[0] = firstDelim.startsWith("[") ? delimArr[0].substring(1) : firstDelim;

            String lastDelim = delimArr[delimLen - 1];
            delimArr[delimLen - 1] = lastDelim.endsWith("]") ? lastDelim.substring(0, lastDelim.lastIndexOf("]"))
                    : lastDelim;
            
            // Q is Quote treats all characters equally
            // E is end of section
            String regex = Stream.of(delimArr)
                    .map(str -> "\\Q" + str + "\\E")
                    .collect(Collectors.joining("|"));

            numArr = numberStr.split(regex);
        }else{
            //default delimiter
            numArr = numbers.split(delimiter);
        }

        return calculateSum(numArr);
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
