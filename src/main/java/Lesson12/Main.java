package Lesson12;

public class Main {

    public static void main(String[] args) {
        testArrayOperations();
    }

    public static void testArrayOperations() {
        // Тестирование обработки массива
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray1 = {  // только 3 столбца
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"10", "11", "12"}
        };

        String[][] wrongSizeArray2 = {   // только 3 строки
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "abc", "10", "11"},
                {"13", "14", "15", "12"}
        };

        try {
            System.out.println("Здесь будет ошибка" + sumArray(wrongSizeArray1));
        } catch (MyArraySizeException | MyArrayDataException error) {
            System.out.println(error.getMessage());
        }

        try {
            System.out.println("Здесь тоже будет ошибка" + sumArray(wrongSizeArray2));
        } catch (MyArraySizeException | MyArrayDataException error) {
            System.out.println(error.getMessage());
        }

        try {
            System.out.println("И здесь будет ошибка" + sumArray(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException error) {
            System.out.println(error.getMessage());
        }

        try {
            System.out.println("Корректный массив 4x4, сумма массива = " + sumArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException error) {
            System.out.println(error.getMessage());
        }

        // Генерация ошибки ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            int value = arr[10]; // Здесь будет исключение
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("\n===== Поимка ArrayIndexOutOfBoundsException ===== \n" + error.getMessage());
        }
    }

    //метод для проверки массива на ошибки размера и содержания
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка количества строк
        if (array.length != 4) {
            throw new MyArraySizeException("\n====== MyArraySizeException ======\n" +
                    "Неверное количество строк. " +
                    "Должно быть 4, а реально " + array.length);
        }

        // Проверка количества столбцов в каждой строке
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("\n====== MyArraySizeException ======\n" +
                        "Неверное количество столбцов в строке " + i +
                        ". Должно быть 4, а реально " + array[i].length);
            }
        }

        //проверяем элементы массива - если все Ок - то выводим - "корректный массив" и сумму элементов
        //если есть некорректный элемент в массиве - выводим ошибку
        int sum = 0;

        // Проверяем все элементы на корректность
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("\n====== MyArrayDataException ======" +
                       "\nНекорректные данные элемента массива [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        // Все проверки пройдены - значит можно вывести, что все Ок
        System.out.println("\nвсе проверки размера массива и его элементов пройдены:");

        // Наконец после всех проверок, можно просуммировать корректный массив
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }
}
