namespace Fizz_Buzz_Csharp;

internal class FizzBuzz
{
    public string Evaluate(int number)
    {
        if (number % 3 == 0)
        {
            return "Fizz";
        }
        
        return number.ToString();
    }
}