namespace Fizz_Buzz_Csharp;

internal class FizzBuzz
{
    private const int FizzMultiplier = 3;
    private const int BuzzMultiplier = 5;
    private const string Fizz = "Fizz";
    private const string Buzz = "Buzz";

    public string Evaluate(int number)
    {
        return number switch
        {
            _ when IsMultipleOf(number, FizzMultiplier)
                   && IsMultipleOf(number, BuzzMultiplier) => Fizz + Buzz,
            _ when IsMultipleOf(number, BuzzMultiplier) => Buzz,
            _ when IsMultipleOf(number, FizzMultiplier) => Fizz,
            _ => number.ToString()
        };
    }

    private static bool IsMultipleOf(int number, int divider) => number % divider == 0;
}