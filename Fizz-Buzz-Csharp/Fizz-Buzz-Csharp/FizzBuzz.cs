namespace Fizz_Buzz_Csharp;

internal class FizzBuzz
{
    public string Evaluate(int number)
    {
        return number % 3 == 0 ? "Fizz" : number.ToString();
    }
}