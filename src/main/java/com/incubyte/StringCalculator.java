package com.incubyte;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        //default delimiter
        String delimiter = ",|\n";
        String[] numArr;

        if (numbers.startsWith("//")) {

            // If numbers is starts with // - custom delimiters
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
        } else {
            //default delimiter
            numArr = numbers.split(delimiter);
        }

        //Negative numbers exception
        String negativeNumbers = Stream.of(numArr)
                .filter(num -> num.startsWith("-"))
                .collect(Collectors.joining(","));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negativeNumbers);
        }

        // Sum and 1000 condition
        return Stream.of(numArr).filter(num -> num.matches("[0-9]+"))
                .map(Integer::parseInt)
                .filter(num -> num <= 1000)
                .reduce(0, (acc, curr) -> acc + curr);
    }
}
