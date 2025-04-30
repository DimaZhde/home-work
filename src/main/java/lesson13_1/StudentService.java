package lesson13_1;

public class StudentService {
    public void iskluchenieStudents(java.util.Set<Student> students) {
        java.util.Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSredOtmetka() < 3.0) {
                iterator.remove();
            }
        }
    }

    public void perevodStudents(java.util.Set<Student> students) {
        for (Student student : students) {
            if (student.getSredOtmetka() >= 3.0) {
                student.perevodToNextCourse();
            }
        }
    }

    public void printStudents(java.util.Set<Student> students, int course) {
        System.out.println("\n===== Студенты " + course + " курса =====");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
