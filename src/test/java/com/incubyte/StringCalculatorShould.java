package com.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorShould {

    @Test
    @DisplayName("Empty string should return 0")
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("Single number should return number as int")
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Multiple numbers should return sum")
    void string_with_multiple_number_should_return_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }


    @Test
    @DisplayName("Multiple numbers with new line delimiter should return sum")
    void string_with_newline_between_numbers_should_return_their_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Add numbers with different delimiter should return the sum")
    void string_with_different_delimiters_should_return_their_sum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
}
