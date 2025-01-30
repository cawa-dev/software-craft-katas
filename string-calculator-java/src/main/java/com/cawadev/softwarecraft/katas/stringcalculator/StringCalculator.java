package com.cawadev.softwarecraft.katas.stringcalculator;

import com.cawadev.softwarecraft.katas.stringcalculator.exception.DelimiterException;

import java.util.Arrays;

class StringCalculator {

    private static final String SPACE = " ";
    private static final String NEW_LINE_DELIMITER = "\\r?\\n";
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_AND_NEW_LINE_DELIMITER =
            "[" + COMMA_DELIMITER + NEW_LINE_DELIMITER + "]";


    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        final var stringWithoutSpaces = removeSpaces(numbers);

        checkDelimiters(stringWithoutSpaces);

        final var numbersArray = splitNumbers(stringWithoutSpaces);

        return sumOfNumbers(numbersArray);
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
                .sum();
    }

    private static String[] splitNumbers(String stringWithoutSpaces) {
        return stringWithoutSpaces.split(COMMA_AND_NEW_LINE_DELIMITER);
    }

    private static String removeSpaces(String numbers) {
        return numbers.replaceAll(SPACE, "");
    }
}
