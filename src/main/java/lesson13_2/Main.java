package lesson13_2;

public class Main {
    public static void main(String[] args) {
        PhoneBook abonent = new PhoneBook();

        // Добавляем записи
        abonent.add("Иванов", "+7-123-456-7890");
        abonent.add("Иванов", "+7-987-654-3210");
        abonent.add("Петров", "+7-222-222-1111");
        abonent.add("Козлов", "+7-333-222-2222");
        abonent.add("Кошкин", "+7-444-222-3333");
        abonent.add("Васечкин", "+7-555-222-5555");

        // Получаем номера
        java.util.ArrayList<String> ivanovPhones = abonent.get("Иванов");
        System.out.println(ivanovPhones.isEmpty() ? "Нет такой фамилии" : "Иванов: " + ivanovPhones);

        java.util.ArrayList<String> vasechkinPhones = abonent.get("Васечкин");
        System.out.println(vasechkinPhones.isEmpty() ? "Нет такой фамилии" : "Васечкин: " + vasechkinPhones);

        java.util.ArrayList<String> sidorovPhones = abonent.get("Сидоров");
        System.out.println(sidorovPhones.isEmpty() ? "Нет такой фамилии" : "Сидоров: " + sidorovPhones);
    }
}
