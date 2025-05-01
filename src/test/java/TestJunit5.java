import Lesson_14_junit_5.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class TestJunit5 {
    private Main math;

    @BeforeEach
    void setUp() {
        math = new Main();
    }

    // Тесты факториала
    @Test
    void factorialOfZeroIsOne() {
        assertEquals(1, math.factorial(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void factorialPositiveNumbers(int n) {
        assertTrue(math.factorial(n) > 0);
    }

    @Test
    void factorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> math.factorial(-1));
    }

    // Тесты площади треугольника
    @ParameterizedTest
    @CsvSource({"10,5,25", "3,4,6", "7.5,2,7.5"})
    void validTriangleArea(double base, double height, double expected) {
        assertEquals(expected, math.triangleArea(base, height), 0.001);
    }

    @Test
    void invalidTriangleArea() {
        assertThrows(IllegalArgumentException.class, () -> math.triangleArea(-1, 5));
    }

    // Тест арифметических операций
    @ParameterizedTest
    @CsvSource({"5,3,+,8", "10,4,-,6", "7,8,*,56", "10,2,/,5.0"})
    void validCalculations(int a, int b, String op, double expected) {
        assertEquals(expected, math.calculate(a, b, op), 0.001);
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> math.calculate(5, 0, "/"));
    }

    // Тесты сравнения чисел
    @ParameterizedTest
    @CsvSource({"5,3,'5 > 3'", "2,4,'2 < 4'", "7,7,'7 == 7'"})
    void numberComparison(int a, int b, String expected) {
        assertEquals(expected, math.compare(a, b));
    }
}