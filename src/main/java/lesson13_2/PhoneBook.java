package lesson13_2;

public class PhoneBook {
    // Телефонная книга содержит: фамилия -> список номеров
    private final java.util.HashMap<String, java.util.ArrayList<String>> book;

    // Создаем новую телефонную книгу
    public PhoneBook() {
        book = new java.util.HashMap<>();
    }

    // Добавить номер для фамилии
    public void add(String lastName, String phoneNumber) {
        // Если фамилии нет - создаем для нее пустой список
        if (!book.containsKey(lastName)) {
            book.put(lastName, new java.util.ArrayList<>());
        }
        // Добавляем номер в список
        book.get(lastName).add(phoneNumber);
    }

    // Получить все номера по фамилии
    public java.util.ArrayList<String> get(String lastName) {
        // Если фамилия есть - возвращаем ее номера
        if (book.containsKey(lastName)) {
            return book.get(lastName);
        }
        // Если фамилии нет - возвращаем пустой список
        return new java.util.ArrayList<>();
    }
}
