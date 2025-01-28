namespace Fizz_Buzz_Csharp;

internal class FizzBuzzTests
{
    [Test]
    public void Should_Return_Same_Number_When_It_Is_Not_Multiple_Of_3_Or_5()
    {
        // Arrange
        const int number = 1;
        var fizzBuzz = new FizzBuzz();

        // Act
        var value = fizzBuzz.Evaluate(number);

        // Assert
        Assert.That(value, Is.EqualTo("1"));
    }
}