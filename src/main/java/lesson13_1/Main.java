package lesson13_1;

public class Main {
    public static void main(String[] args) {
        // создаем коллекцию студентов с порядком добавления
        java.util.Set<Student> students = new java.util.LinkedHashSet<>();

        // Добавляем 5 студентов
        students.add(new Student("Иванов Иван", "Группа 101", 1,
                java.util.Map.of("Математика", 2, "Физика", 2, "История", 3)));

        students.add(new Student("Петров Петр", "Группа 102", 2,
                java.util.Map.of("Математика", 2, "Физика", 3, "История", 2)));

        students.add(new Student("Сидоров Василий", "Группа 201", 1,
                java.util.Map.of("Математика", 3, "Физика", 3, "История", 3)));

        students.add(new Student("Кузнецова Мария", "Группа 301", 3,
                java.util.Map.of("Математика", 3, "Физика", 5, "История", 4)));

        students.add(new Student("Смирнов Алексей", "Группа 401", 4,
                java.util.Map.of("Математика", 5, "Физика", 5, "История", 5)));

        // Выводим исходный список студентов
        System.out.println("\n===== Исходный список студентов =====");
        for (Student student : students) {
            System.out.println(student);
        }

        // Обрабатываем студентов для исключения и перевода на след.курс
        StudentService service = new StudentService();
        service.perevodStudents(students);
        service.iskluchenieStudents(students);

        // Выводим список студентов после обработки
        System.out.println("\n===== Список после обработки =====");
        for (Student student : students) {
            System.out.println(student);
        }

        // Выводим студентов 2 курса
        service.printStudentsCourse(students, 2);
    }
}