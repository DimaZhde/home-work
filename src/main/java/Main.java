public class Main {
    //1 (три слова)
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //2 (если a+b>=0 - положительная)
    public static void checkSumSign() {
        int a = 38;
        int b = -46;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3 (если: х<=0 Красный; х>0 и х<=100 желтый; х>100 зеленый)
    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4 (a>=b или a<b)
    public static void compareNumbers() {
        int a = 75;
        int b = 75;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //5 (если сумма входящих (10 до 20] - true; false)
    public static boolean ChisloVDiapazone(int a, int b) {
        int summa = a + b;
        return summa > 10 && summa <= 20;
    }

    //6 (Если входящее: >=0 положительное; <0 отрицательное)
    public static void ProverkaChisla(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //7 (если входящее: х<0 true; x>=0 false)
    public static boolean isNegative(int х) {
        return х < 0;
    }

    //8 (печатаем входящую строку в кол-ве входящего числа)
    public static void PtchatStrokiXRaz(String stroka, int pechatRaz) {
        for (int i = 0; i < pechatRaz; i++) {
            System.out.println(stroka);
        }
    }

    //9 (Каждый 4й високосный, кроме каждого 100го, но каждый 400й високосный)
    public static boolean VisokosniyGod(int god) {
        return (god % 4 == 0 && god % 100 != 0) || (god % 400 == 0);

    }

    //10 (Задать массив из элементов 0 и 1 и циклом заменить 0 на 1, 1 на 0)
    public static void invertMassiv() {
        int[] massiv = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("       Исходный массив: ");
        for (int i : massiv) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i] == 1) {
                massiv[i] = 0;
            } else {
                massiv[i] = 1;
            }
        }

        System.out.print("Инвертированный массив: ");
        for (int i : massiv) {
            System.out.print(i);
        }
        System.out.println();
    }

    //11 (Задать пустой массив длиной 100, циклом заполнить его значениями от 1 до 100)
    public static void sotnya() {
        int[] massiv100 = new int[100];
        for (int i = 0; i < massiv100.length; i++) {
            massiv100[i] = i + 1;
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(massiv100[i] + " ");
        }

    }

    //12 (Задать массив и циклом числа <6 умножить на 2)
    public static void massivX6() {
        int[] massiv = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("  Исходный массив: ");
        for (int i : massiv) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i] < 6) {
                massiv[i] *= 2;
            }
        }

        System.out.print("\nИзмененный массив: ");
        for (int i : massiv) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //13 (Квадратный массив с диагоналями из единиц)
    public static void Matrica(int razmer) {
        int[][] MatricaRazmer = new int[razmer][razmer];

        for (int i = 0; i < razmer; i++) {
            MatricaRazmer[i][i] = 1; // Первая диагональ (\)
            MatricaRazmer[i][razmer - 1 - i] = 1; // Вторая диагональ (/)
        }

        for (int[] row : MatricaRazmer) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //14 (на вход аргументы: len и initialValue; возвращает одномерный массив типа int длиной len, каждая ячейка которого равна initialValue)
    public static void odnomerMassiv(int len, int initialValue) {
        int[] massiv = new int[len];
        for (int i = 0; i < len; i++) {
            massiv[i] = initialValue;
        }

        System.out.print("Одномерный массив длиной " + len + " со значениями " + initialValue + ": ");
        for (int i : massiv) {
            System.out.print(i + " ");
        }
        System.out.println();
    }



    //Вывод заданий в консоль (1-4, 6, 8)
    public static void main(String[] args) {
        System.out.println("\n ---Задание 01 (Три слова в столбик)---");
        printThreeWords();

        System.out.println("\n ---Задание 02 (сумма + или -)---");
        checkSumSign();

        System.out.println("\n ---Задание 03---");
        printColor();

        System.out.println("\n ---Задание 04---");
        compareNumbers();

        System.out.println("\n ---Задание 06---");
        ProverkaChisla(-5);  // Отрицательное
        ProverkaChisla(0);    // Положительное (0)

        System.out.println("\n ---Задание 08---");
        PtchatStrokiXRaz("Котики", 5); // Печатает 5 раз

        System.out.println("\n ---Задание 09---");
        System.out.println(VisokosniyGod(2025)); // true

        System.out.println("\n ---Задание 10 (Инверсия массива)---");
        invertMassiv();

        System.out.println("\n ---Задание 11---");
        sotnya();

        System.out.println("\n\n ---Задание 12---");
        massivX6();

        System.out.println("\n ---Задание 13---");
        Matrica(7);

        System.out.println("\n ---Задание 14---");
        odnomerMassiv(7, 12);
    }

}
