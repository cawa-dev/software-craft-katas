package com.cawadev.softwarecraft.katas.fizzbuzz;

public record FizzBuzz() {

    private static final int BUZZ_MULTIPLIER = 5;
    private static final int FIZZ_MULTIPLIER = 3;

    public String print(int number) {
        if (number % FIZZ_MULTIPLIER == 0 && number % BUZZ_MULTIPLIER == 0) {
            return "FizzBuzz";
        }

        if (number % BUZZ_MULTIPLIER == 0) {
            return "Buzz";
        }

        if (number % FIZZ_MULTIPLIER == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
