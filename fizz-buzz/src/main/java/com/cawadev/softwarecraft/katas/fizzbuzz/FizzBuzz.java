package com.cawadev.softwarecraft.katas.fizzbuzz;

public record FizzBuzz() {

    private static final int FIZZ_MULTIPLIER = 3;

    public String print(int number) {
        if (number % FIZZ_MULTIPLIER == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
