package lesson13_1;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final java.util.Map<String, Integer> otmetki;

    public Student(String name, String group, int course, java.util.Map<String, Integer> otmetki) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.otmetki = new java.util.HashMap<>(otmetki);
    }

    public double getSredOtmetka() {
        if (otmetki.isEmpty()) return 0.0;
        double sum = 0.0;
        for (int grade : otmetki.values()) {
            sum += grade;
        }
        return sum / otmetki.size();
    }

    // курс не может быть больше 5
    public void perevodToNextCourse() {
        if (course < 5) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ", Средний балл: " + String.format("%.1f", getSredOtmetka()) + ")";
    }
}