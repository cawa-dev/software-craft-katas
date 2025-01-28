namespace Fizz_Buzz_Csharp;

internal class FizzBuzzTests
{
    private FizzBuzz _fizzBuzz;

    [SetUp]
    public void Setup()
    {
        _fizzBuzz = new FizzBuzz();
    }

    [Test]
    public void Should_Return_Same_Number_When_It_Is_Not_Multiple_Of_Three_Or_Five()
    {
        // Arrange
        const int number = 1;

        // Act
        var value = _fizzBuzz.Evaluate(number);

        // Assert
        Assert.That(value, Is.EqualTo("1"));
    }

    [Test]
    public void Should_Return_Fizz_When_It_Is_Multiple_Of_Three()
    {
        // Arrange
        const int number = 3;

        // Act
        var value = _fizzBuzz.Evaluate(number);

        // Assert
        Assert.That(value, Is.EqualTo("Fizz"));
    }

    [Test]
    public void Should_Return_Buzz_When_It_Is_Multiple_Of_Five()
    {
        // Arrange
        const int number = 5;

        // Act
        var value = _fizzBuzz.Evaluate(number);

        // Assert
        Assert.That(value, Is.EqualTo("Buzz"));
    }

    [Test]
    public void Should_Return_FizzBuzz_When_It_Is_Multiple_Of_Three_And_Five()
    {
        // Arrange
        const int number = 15;

        // Act
        var value = _fizzBuzz.Evaluate(number);

        // Assert
        Assert.That(value, Is.EqualTo("FizzBuzz"));
    }
}