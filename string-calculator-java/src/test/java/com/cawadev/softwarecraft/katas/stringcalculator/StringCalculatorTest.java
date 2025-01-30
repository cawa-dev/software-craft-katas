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
        String number = "1";

        // Act
        int result = stringCalculator.add(number);


        // Assert
        assertThat(result).isEqualTo(1);
    }
}
