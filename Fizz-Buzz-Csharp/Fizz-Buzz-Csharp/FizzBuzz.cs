namespace Fizz_Buzz_Csharp;

internal class FizzBuzz
{
    public string Evaluate(int number)
    {
        return number switch
        {
            _ when number % 15 == 0 => "FizzBuzz",
            _ when number % 5 == 0 => "Buzz",
            _ when number % 3 == 0 => "Fizz",
            _ => number.ToString()
        };
    }
}