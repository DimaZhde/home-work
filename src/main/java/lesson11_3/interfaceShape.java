package lesson11_3;

// Интерфейс
interface Shape {
    double getArea();
    String getFillColor();
    String getBorderColor();

    // Дефолт. Расчета периметра
    default double getPerimeter() {
        return 0;
    }

    // Дефолт. Вывод информации о фигуре
    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("===========================================");
    }
}
