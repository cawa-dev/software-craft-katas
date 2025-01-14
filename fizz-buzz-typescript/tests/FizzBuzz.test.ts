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
});
