package com.cawadev.softwarecraft.katas.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Should return same number when it is not multiple of three or five")
    void should_return_same_number_when_it_is_not_multiple_of_three_or_five() {
        // ARRANGE
        int number = 1;

        // ACT
        String value = fizzBuzz.evaluate(number);

        // ASSERT
        assertEquals("1", value);
    }

    @Test
    @DisplayName("Should return Fizz when number is multiple of three")
    void should_return_fizz_when_number_is_multiple_of_three() {
        // ARRANGE
        int number = 3;

        // ACT
        String value = fizzBuzz.evaluate(number);

        // ASSERT
        assertEquals("Fizz", value);
    }

    @Test
    @DisplayName("Should return Buzz when number is multiple of five")
    void should_return_buzz_when_number_is_multiple_of_five() {
        // ARRANGE
        int number = 5;

        // ACT
        String value = fizzBuzz.evaluate(number);

        // ASSERT
        assertEquals("Buzz", value);
    }

    @Test
    @DisplayName("Should return FizzBuzz when number is multiple of three and five")
    void should_return_fizzbuzz_when_number_is_multiple_of_three_and_five() {
        // ARRANGE
        int number = 15;

        // ACT
        String value = fizzBuzz.evaluate(number);

        // ASSERT
        assertEquals("FizzBuzz", value);
    }
}
