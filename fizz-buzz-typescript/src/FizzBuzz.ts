const BUZZ_MULTIPLIER = 5;
const FIZZ_MULTIPLIER = 3;

const BUZZ = "Buzz";
const FIZZ = "Fizz";

export const fizzBuzz: {
    evaluate: (number: number) => string
} = ({
    evaluate: (number: number): string => {
        if (isMultiplyOf(number, FIZZ_MULTIPLIER)
            && isMultiplyOf(number, BUZZ_MULTIPLIER)) {
            return FIZZ + BUZZ;
        }

        if (isMultiplyOf(number, BUZZ_MULTIPLIER)) {
            return BUZZ;
        }

        if (isMultiplyOf(number, FIZZ_MULTIPLIER)) {
            return FIZZ;
        }

        return number.toString();
    }
});

function isMultiplyOf(number: number, divider: number): boolean {
    return number % divider === 0;
}
