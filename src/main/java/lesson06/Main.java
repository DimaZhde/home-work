//2. Создать массив из 5 товаров.
//   название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем
package lesson06;
public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5]; // Массив из 5 товаров
        // Заполнение массива Product-ами
        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                15000,
                true);

        productsArray[1] = new Product(
                "iPhone 15",
                "01.01.2024",
                "Apple",
                "USA",
                75000,
                false);

        productsArray[2] = new Product(
                "Xiaomi Mi 11 Ultra",
                "01.01.2023",
                "Xiaomi",
                "China",
                43600,
                true);

        productsArray[3] = new Product(
                "Sony WH-1000XM5",
                "01.01.2022",
                "Sony",
                "Japan",
                32000,
                false);

        productsArray[4] = new Product(
                "Dyson Supersonic HD07",
                "01.01.2021",
                "Dyson",
                "Great Britain",
                24999,
                true);

        // Выводим информацию о всех товарах в консоль
        for (Product product : productsArray) {
            product.vivodInfoProduct();
        }
    }
}