package com.cawadev.softwarecraft.katas.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void should_return_zero_when_the_string_is_empty() {
        // Arrange
        String emptyString = "";

        // Act
        int result = stringCalculator.add(emptyString);

        // Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_return_the_same_number_when_one_number_is_passed() {
        // Arrange
        String number = "5";

        // Act
        int result = stringCalculator.add(number);


        // Assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    void should_return_the_sum_of_the_number_separate_by_comma_in_the_string() {
        // Arrange
        String numbers = "5,4";

        // Act
        int result = stringCalculator.add(numbers);

        // Assert
        assertThat(result).isEqualTo(9);
    }

    @Test
    void should_return_the_sum_of_numbers_separate_by_comma_in_the_string_with_space_inside() {
        // Arrange
        String numbers = "1, 2";

        // Act
        int result = stringCalculator.add(numbers);

        // Assert
        assertThat(result).isEqualTo(3);
    }
}
