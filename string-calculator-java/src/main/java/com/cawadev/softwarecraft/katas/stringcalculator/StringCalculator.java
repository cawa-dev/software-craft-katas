package com.cawadev.softwarecraft.katas.stringcalculator;

import java.util.Arrays;

class StringCalculator {

    private static final String SPACE = " ";
    public static final String COMMA_AND_NEW_LINE_DELIMITER = "[,\\r?\\n]";

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        final var stringWithoutSpaces = removeSpaces(numbers);

        final var numbersArray = splitNumbers(stringWithoutSpaces);

        return sumOfNumbers(numbersArray);
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
