import Lesson_14_testng.Main;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MainTest {
    private final Main main = new Main();

    // ========== Тесты для факториала ==========
    @Test
    public void testFactorialPositive() {
        assertEquals(main.factorial(5), 120L);
        assertEquals(main.factorial(0), 1L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        main.factorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialTooLarge() {
        main.factorial(21); // >20 вызывает исключение
    }

    // ========== Тесты для площади треугольника ==========
    @Test
    public void testTriangleAreaValid() {
        assertEquals(main.triangleArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaInvalidBase() {
        main.triangleArea(-10, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaInvalidHeight() {
        main.triangleArea(10, -5);
    }

    // ========== Тесты для калькулятора ==========
    @Test
    public void testCalculateAddition() {
        assertEquals(main.calculate(3, 2, "+"), 5.0);
    }

    @Test
    public void testCalculateDivision() {
        assertEquals(main.calculate(10, 2, "/"), 5.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testCalculateDivisionByZero() {
        main.calculate(10, 0, "/");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateUnknownOperation() {
        main.calculate(10, 2, "unknown");
    }

    // ========== Тесты для сравнения чисел ==========
    @Test
    public void testCompareGreater() {
        assertEquals(main.compare(5, 3), "5 > 3");
    }

    @Test
    public void testCompareLess() {
        assertEquals(main.compare(3, 5), "3 < 5");
    }

    @Test
    public void testCompareEqual() {
        assertEquals(main.compare(5, 5), "5 == 5");
    }
}