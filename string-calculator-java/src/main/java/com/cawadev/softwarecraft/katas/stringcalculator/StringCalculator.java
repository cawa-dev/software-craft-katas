package com.cawadev.softwarecraft.katas.stringcalculator;

import java.util.Arrays;

class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String stringWithoutSpaces = numbers.replaceAll(" ", "");

        String[] numbersArray = stringWithoutSpaces.split(",");

        return Arrays.stream(numbersArray)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
