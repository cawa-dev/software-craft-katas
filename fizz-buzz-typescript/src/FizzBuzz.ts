export const fizzBuzz: {
    evaluate: (number: number) => string
} = ({
    evaluate: (number: number): string => {
        if (number % 5 == 0) {
            return "Buzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        return number.toString();
    }
});
