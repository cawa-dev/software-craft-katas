package com.cawadev.softwarecraft.katas.fizzbuzz;

class FizzBuzz {

    private static final int BUZZ_MULTIPLIER = 5;
    private static final int FIZZ_MULTIPLIER = 3;
    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";

    public String evaluate(int number) {
        if (isMultipleOf(number, FIZZ_MULTIPLIER)
                && isMultipleOf(number, BUZZ_MULTIPLIER)) {
            return FIZZ + BUZZ;
        }

        if (isMultipleOf(number, BUZZ_MULTIPLIER)) {
            return BUZZ;
        }

        if (isMultipleOf(number, FIZZ_MULTIPLIER)) {
            return FIZZ;
        }

        return String.valueOf(number);
    }

    private boolean isMultipleOf(int number, int divider) {
        return number % divider == 0;
    }
}
