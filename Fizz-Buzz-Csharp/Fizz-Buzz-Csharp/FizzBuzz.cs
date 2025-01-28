namespace Fizz_Buzz_Csharp;

internal class FizzBuzz
{
    public string Evaluate(int number)
    {
        return number switch
        {
            3 => "Fizz",
            5 => "Buzz",
            _ => number.ToString()
        };
    }
}