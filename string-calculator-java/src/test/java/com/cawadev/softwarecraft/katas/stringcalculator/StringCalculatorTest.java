package com.cawadev.softwarecraft.katas.stringcalculator;

import com.cawadev.softwarecraft.katas.stringcalculator.exception.DelimiterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    void should_return_the_sum_of_the_numbers_separate_by_comma_in_the_string() {
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

    @Test
    void should_return_the_sum_of_numbers_separate_by_a_new_line_in_the_string() {
        // Arrange
        String numbers = "3\n3";

        // Act
        int result = stringCalculator.add(numbers);

        // Assert
        assertThat(result).isEqualTo(6);
    }

    @Test
    void should_return_the_sum_of_numbers_separate_by_a_new_line_in_the_string_with_spaces() {
        // Arrange
        String numbers = "10 \n 12";

        // Act
        int result = stringCalculator.add(numbers);

        // Assert
        assertThat(result).isEqualTo(22);
    }

    @Test
    void should_return_the_sum_of_numbers_separate_by_a_new_line_and_a_comma_in_the_string() {
        // Arrange
        String numbers = "1\n2,3";

        // Act
        int result = stringCalculator.add(numbers);

        // Assert
        assertThat(result).isEqualTo(6);
    }

    @Test
    void should_throw_a_delimiter_exception_when_there_is_comma_and_new_line_together() {
        // Arrange
        String stringWithTwoDelimiters = "1,\n";

        // Act & Assert
        assertThatExceptionOfType(DelimiterException.class)
                .isThrownBy(() -> stringCalculator.add(stringWithTwoDelimiters))
                .withMessage("Two delimiters together are not allowed");
    }

    @Test
    void should_throw_a_delimiter_exception_when_there_is_new_line_and_comma_together() {
        // Arrange
        String stringWithTwoDelimiters = "1\n,";

        // Act & Assert
        assertThatExceptionOfType(DelimiterException.class)
                .isThrownBy(() -> stringCalculator.add(stringWithTwoDelimiters))
                .withMessage("Two delimiters together are not allowed");
    }
}
