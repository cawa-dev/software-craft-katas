package com.cawadev.softwarecraft.katas.fizzbuzz;

public record FizzBuzz() {

    public String print(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
