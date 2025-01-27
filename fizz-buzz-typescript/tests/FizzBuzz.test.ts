import {fizzBuzz} from "../src/FizzBuzz";

describe(('FizzBuzz'), () => {

    it("Should return same number when it is not multiple of three or five", () => {
        // Arrange
        const number: number = 1;

        // Act
        const value: string = fizzBuzz.evaluate(number);

        // Assert
        expect(value).toBe("1");
    });


    it("Should return Fizz when number is multiple of three", () => {
        // Arrange
        const number: number = 3;

        // Act
        const value: string = fizzBuzz.evaluate(number);

        // Assert
        expect(value).toBe("Fizz")
    });

    it("Should return Buzz when number is multiple of five", () => {
        // Arrange
        const number: number = 5;

        // Act
        const value: string = fizzBuzz.evaluate(number);

        // Assert
        expect(value).toBe("Buzz")
    });

    it("Should return FizzBuzz when number is multiple of three and five", () => {
        // Arrange
        const number: number = 15;

        // Act
        const value: string = fizzBuzz.evaluate(number);

        // Assert
        expect(value).toBe("FizzBuzz")
    });
});
