package com.incubyte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
        stringCalculator = null;
    }


    @Test
    @DisplayName("Empty string should return 0")
    void empty_string_should_return_0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("Single number should return number as int")
    void string_with_single_number_should_return_number_as_int() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Multiple numbers should return sum")
    void string_with_multiple_number_should_return_sum() {
        assertEquals(3, stringCalculator.add("1,2"));
    }


    @Test
    @DisplayName("Multiple numbers with new line delimiter should return sum")
    void string_with_newline_between_numbers_should_return_their_sum() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Add numbers with different delimiter should return the sum")
    void string_with_different_delimiters_should_return_their_sum() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }


    @Test
    @DisplayName("Adding negative number should throw exception")
    void string_with_negative_numbers_should_throw_exception_with_message() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("1,-2,3");
        });
        assertEquals("negative numbers not allowed: -2", exception.getMessage());
    }

    @Test
    @DisplayName("Numbers greater than 1000 should be ignored")
    void string_with_numbers_greater_than_1000_should_be_ignored_in_sum() {
        assertEquals(2, stringCalculator.add("2,1001"));
        assertEquals(1005, stringCalculator.add("5,1000"));
    }

    @Test
    @DisplayName("Any length delimiter return sum")
    void string_with_any_length_delimiter_should_return_their_sum() {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    @DisplayName("Multiple Delimiters with length longer than one char")
    void string_with_multiple_delimiters_should_return_their_sum() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

}
