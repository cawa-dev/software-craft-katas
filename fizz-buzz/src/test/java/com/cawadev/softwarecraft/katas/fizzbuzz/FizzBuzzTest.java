package com.cawadev.softwarecraft.katas.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class FizzBuzzTest {

    @Test
    @DisplayName("Should return same number when it is not multiple of three or five")
    void should_return_same_number_when_it_is_not_multiple_of_three_or_five() {
        // ARRANGE
        FizzBuzz fizzBuzz = new FizzBuzz();
        int number = 1;

        // ACT
        String value = fizzBuzz.print(number);

        // ASSERT
        assertEquals("1", value);
    }
}