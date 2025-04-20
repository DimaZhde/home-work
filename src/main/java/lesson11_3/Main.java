package lesson11_3;
//    Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
//        •	Круг
//        •	Прямоугольник
//        •	Треугольник
//        Задать для каждой фигуры цвет заливки и цвет границы.
//        Результат полученных характеристик [Периметр, площадь, цвет фона, цвет границ]
//        по каждой фигуре вывести в консоль.
//
//        Попробуйте реализовать базовые методы, такие как расчет периметра фигур,
//        в качестве дефолтных методов в интерфейсе.

public class Main {
    public static void main(String[] args) {
        // Создание фигур
        Shape circle = new Circle(5, "Красный", "Желтрый");
        Shape chetireangle = new Chetireangle(4, 6, "Зеленый", "Синий");
        Shape triangle = new Triangle(3, 4, 5, "Белый", "Фиолетовый");

        // Вывод информации о фигурах
        System.out.println("===========================================");
        System.out.println("  Круг:");
        circle.printInfo();

        System.out.println("  Прямоугольник:");
        chetireangle.printInfo();

        System.out.println("  Треугольник:");
        triangle.printInfo();
    }













}

















//
//public class Main {
//    public static void main(String[] args) {
//        // Создаем животных
//        Zhivotnoe dog1 = new Dog("Бобик");
//        Zhivotnoe dog2 = new Dog("Шарик");
//        Zhivotnoe cat1 = new Cat("Барсик");
//        Zhivotnoe cat2 = new Cat("Мурзик");
//        Zhivotnoe cat3 = new Cat("Васька");
//
//        // Тестируем базовую функциональность
//        dog1.begat(150);
//        dog1.plavat(5);
//        dog1.plavat(15);
//
//        cat1.begat(100);
//        cat1.begat(250);
//        cat1.plavat(5);
//
//        System.out.println("\nВсего животных: " + Zhivotnoe.KolichestvoZhivotnih());
//        System.out.println("Всего собак: " + Dog.poluchitKolichestvoSobak());
//        System.out.println("Всего котов: " + Cat.poluchitKolichestvoKotov());
//
//        // Новая функциональность с миской и кормлением
//        System.out.println("\n--- Кормление котов ---");
//
//        // Создаем миску с едой
//        MiskaEdi miskaEdi = new MiskaEdi(50); // Миска с 50 единицами еды
//
//        // Создаем массив котов
//        Cat[] massivKotov = new Cat[5];
//        massivKotov[0] = new Cat("Барсик");
//        massivKotov[1] = new Cat("Мурзик");
//        massivKotov[2] = new Cat("Васька");
//        massivKotov[3] = new Cat("Рыжик");
//        massivKotov[4] = new Cat("Дашкун");
//
//        // Кормим всех котов из миски
//        for (int i = 0; i < massivKotov.length; i++) {
//            massivKotov[i].est(miskaEdi);
//        }
//
//        // Выводим информацию о сытости котов
//        System.out.println("\nСостояние котов после кормления:");
//        for (int i = 0; i < massivKotov.length; i++) {
//            System.out.println("Кот " + massivKotov[i].poluchImyaZhivotnogo() + ": " +
//                    (massivKotov[i].sytost() ? "сыт" : "голоден"));
//        }
//        System.out.println("\nОстаток еды в миске: " + miskaEdi.KolichestvoEdiVMiske()); // Выводим остаток еды в миске
//
//        // Добавляем еду в миску
//        miskaEdi.dobavitEdu(30);
//        System.out.println("После добавления еды в миске: " + miskaEdi.KolichestvoEdiVMiske());
//    }
//}
//
//
//
//
//
//class Zhivotnoe {
//    private String name;
//    private static int KolichestvoZhiv = 0;
//
//    public Zhivotnoe(String imya) {
//        this.name = imya;
//        KolichestvoZhiv++;
//    }
//
//    public static int KolichestvoZhivotnih() {
//        return KolichestvoZhiv;
//    }
//
//    public void begat(int rasstoyanie) {
//        System.out.println(name + " пробежал " + rasstoyanie + " м.");
//    }
//
//    public void plavat(int rasstoyanie) {
//        System.out.println(name + " проплыл " + rasstoyanie + " м.");
//    }
//
//    public String poluchImyaZhivotnogo() {
//        return name;
//    }
//}
//
//
//
//
//
//
//
//class Dog extends Zhivotnoe {
//    private static final int MAKS_BEGA_DOG = 500;
//    private static final int MAKS_PLAVANIYA_DOG = 10;
//    private static int kolichestvoSobak = 0;
//
//    public Dog(String imya) {
//        super(imya);
//        kolichestvoSobak++;
//    }
//
//    @Override
//    public void begat(int rasstoyanie) {
//        if (rasstoyanie <= MAKS_BEGA_DOG) {
//            super.begat(rasstoyanie);
//        } else {
//            System.out.println(poluchImyaZhivotnogo() + " не может пробежать " + rasstoyanie + " м.");
//        }
//    }
//
//    @Override
//    public void plavat(int rasstoyanie) {
//        if (rasstoyanie <= MAKS_PLAVANIYA_DOG) {
//            super.plavat(rasstoyanie);
//        } else {
//            System.out.println(poluchImyaZhivotnogo() + " не может проплыть " + rasstoyanie + " м.");
//        }
//    }
//
//    public static int poluchitKolichestvoSobak() {
//        return kolichestvoSobak;
//    }
//}
//
//
//
//
//
//
//class Cat extends Zhivotnoe {
//    private static final int MAKS_BEGA_CAT = 200;
//    private static int kolichestvoKotov = 0;
//    private boolean sytost;
//    private int APPETIT = 15; // Сколько еды нужно коту для насыщения
//
//    public Cat(String imya) {
//        super(imya);
//        kolichestvoKotov++;
//        this.sytost = false; // При создании кот голоден
//    }
//
//    @Override
//    public void begat(int rasstoyanie) {
//        if (rasstoyanie <= MAKS_BEGA_CAT) {
//            super.begat(rasstoyanie);
//        } else {
//            System.out.println(poluchImyaZhivotnogo() + " не может пробежать " + rasstoyanie + " м.");
//        }
//    }
//
//    @Override
//    public void plavat(int rasstoyanie) {
//        System.out.println(poluchImyaZhivotnogo() + " не умеет плавать");
//    }
//
//    public void est(MiskaEdi miskaEdi) {
//        if (miskaEdi.umenshitEdu(APPETIT)) {
//            this.sytost = true;
//            System.out.println(poluchImyaZhivotnogo() + " поел и теперь сыт!");
//        } else {
//            System.out.println(poluchImyaZhivotnogo() + " не смог поесть, в миске недостаточно еды!");
//        }
//    }
//
//    public boolean sytost() {
//        return sytost;
//    }
//
//    public static int poluchitKolichestvoKotov() {
//        return kolichestvoKotov;
//    }
//}
//
//
//
//class MiskaEdi {
//    private int kolichestvoEdi;
//
//    public MiskaEdi(int nachalnoeKolichestvo) {
//        if (nachalnoeKolichestvo < 0) {
//            throw new IllegalArgumentException("Количество еды не может быть отрицательным");
//        }
//        this.kolichestvoEdi = nachalnoeKolichestvo;
//    }
//
//    public boolean umenshitEdu(int kolichestvo) {
//        if (kolichestvo <= 0) {
//            return false;
//        }
//        if (this.kolichestvoEdi >= kolichestvo) {
//            this.kolichestvoEdi -= kolichestvo;
//            return true;
//        }
//        return false;
//    }
//
//    public void dobavitEdu(int kolichestvo) {
//        if (kolichestvo < 0) {
//            throw new IllegalArgumentException("Нельзя добавить отрицательное количество еды");
//        }
//        this.kolichestvoEdi += kolichestvo;
//    }
//
//    public int KolichestvoEdiVMiske() {
//        return this.kolichestvoEdi;
//    }
//}
//
//

