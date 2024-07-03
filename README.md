String Calculator

The String Calculator is a simple utility that adds numbers provided as a string input. It supports various features to handle different input formats and scenarios as described below.

Features

Basic Functionality

    Empty String: Returns 0.
    Single Number: Returns the number itself.
    Two Numbers: Returns the sum of two comma-separated numbers.

Additional Features

    Unknown Amount of Numbers: Handles an unknown amount of numbers separated by commas.
    New Lines Between Numbers: Supports new lines between numbers as well as commas ("\n" and ",").
    Support Different Delimiters: Allows changing the delimiter using the format //[delimiter]\n[numbers...]. For example, //;\n1;2 uses ; as the delimiter.
    Negative Numbers Handling: Throws an exception with the message "negatives not allowed" if a negative number is passed.
    Numbers Greater than 1000: Ignores numbers greater than 1000 in calculations.
    Delimiters of Any Length: Supports delimiters of any length using the format //[delimiter]\n. For example, //[***]\n1***2***3.
    Multiple Delimiters: Supports multiple delimiters using the format //[delim1][delim2]\n. For example, //[*][%]\n1*2%3.
    Multiple Delimiters with Length Longer than One Character: Handles multiple delimiters with lengths longer than one character.

Implementation

The implementation follows a Test-Driven Development (TDD) approach with progressively more complex test cases to ensure robust functionality and edge case handling.



Incubyte assessment link - https://blog.incubyte.co/blog/tdd-assessment/
