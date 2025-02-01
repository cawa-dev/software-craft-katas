package com.cawadev.softwarecraft.katas.stringcalculator;

import com.cawadev.softwarecraft.katas.stringcalculator.exception.DelimiterException;
import com.cawadev.softwarecraft.katas.stringcalculator.exception.NegativeNumberException;

import java.util.Arrays;

class StringCalculator {

    private static final String SPACE = " ";
    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_AND_NEW_LINE_DELIMITER =
            "[" + COMMA_DELIMITER + NEW_LINE_DELIMITER + "]";


    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        final var stringWithoutSpaces = removeSpaces(numbers);

        checkDelimiters(stringWithoutSpaces);

        final var numbersArray = splitNumbers(stringWithoutSpaces);

        checkNegativeNumbers(numbersArray);

        return sumOfNumbers(numbersArray);
    }

    private void checkNegativeNumbers(String[] numbersArray) {
        final String[] negativeNumbers = Arrays.stream(numbersArray)
                .filter(number -> number.startsWith("-"))
                .toArray(String[]::new);

        if (negativeNumbers.length > 0) {
            throw new NegativeNumberException("Negatives not allowed: "
                    + String.join(", ", negativeNumbers));
        }
    }

    private void checkDelimiters(String stringWithoutSpaces) {
        if (stringWithoutSpaces.contains(COMMA_DELIMITER + NEW_LINE_DELIMITER)
                || stringWithoutSpaces.contains(NEW_LINE_DELIMITER + COMMA_DELIMITER)) {
            throw new DelimiterException("Two delimiters together are not allowed");
        }
    }

    private static int sumOfNumbers(String[] numbersArray) {
        return Arrays.stream(numbersArray)
                .mapToInt(Integer::parseInt)
                .filter(number ->  number < 1000)
                .sum();
    }

    private static String[] splitNumbers(String stringWithoutSpaces) {
        return stringWithoutSpaces.split(COMMA_AND_NEW_LINE_DELIMITER);
    }

    private static String removeSpaces(String numbers) {
        return numbers.replace(SPACE, "");
    }
}
