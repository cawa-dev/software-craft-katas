package com.cawadev.softwarecraft.katas.stringcalculator;

class StringCalculator {

    public int add(String numbers) {
        return numbers.isEmpty() ? 0 : Integer.parseInt(numbers);
    }
}
