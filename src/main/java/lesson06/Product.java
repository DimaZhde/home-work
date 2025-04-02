//1. Создать класс "Товар" с полями:
//название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль
package lesson06;
public class Product {
    private String name;              // название
    private String productionDate;    // дата производства
    private String manufacturer;      // производитель
    private String country;           // страна происхождения
    private int price;                // цена
    private boolean yesNoBron;        // состояние бронирования покупателем

    // Конструктор класса Товар
    public Product(String name, String productionDate, String manufacturer,
                   String countryOrigin, int price, boolean yesNoBron) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = countryOrigin;
        this.price = price;
        this.yesNoBron = yesNoBron;
    }

    // Метод для вывода информации о товаре в консоль
    public void vivodInfoProduct() {
        System.out.println("\nНазвание: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + " рублей");
        System.out.println("Забронирован: " + (yesNoBron ? "Да" : "Нет"));
    }
}