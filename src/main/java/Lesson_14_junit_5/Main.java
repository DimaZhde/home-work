package Lesson_14_junit_5;

public class Main {
        //Факториал
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал для отрицательного числа не определяется");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Слишком большое число для long");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
        //Площадь треугольника
    public double triangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными");
        }
        return (base * height) / 2.0;
    }
        //Калькулятор двух чисе
    public double calculate(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно");
                }
                return (double) a / b;
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + operation);
        }
    }
        //Сравненение двух чисе
    public String compare(int a, int b) {
        if (a > b) {
            return a + " > " + b;
        } else if (a < b) {
            return a + " < " + b;
        } else {
            return a + " == " + b;
        }
    }

    public static void main(String[] args) {
        Main math = new Main();

        System.out.println("=== Демонстрация работы ===");

        System.out.println("Факториал 5: " + math.factorial(5));
        System.out.println("Площадь треугольника (10x5): " + math.triangleArea(10, 5));
        System.out.println("10 / 3 = " + math.calculate(10, 3, "/"));
        System.out.println("Сравнение 7 и 5: " + math.compare(7, 5));

        try {
            System.out.println("Факториал -1: " + math.factorial(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}