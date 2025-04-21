package lesson11_1;

public class Main {
    public static void main(String[] args) {
        // Создаем животных
        Animals dog1 = new Dog("Бобик");
        Animals dog2 = new Dog("Шарик");
        Animals cat1 = new Cat("Мурзик");
        Animals cat2 = new Cat("Барсик");
        Animals cat3 = new Cat("Васька");

        System.out.println("===================================");
        dog1.run(150);
        dog1.swim(5);
        dog1.swim(15);
        cat1.run(100);
        cat1.run(250);
        cat1.swim(5);

        System.out.println("\nВсего животных: " + Animals.getTotalAnimals());
        System.out.println("- Из них собак: " + Dog.getTotalDogs());
        System.out.println("- Из них котов: " + Cat.getTotalCats());


        // Кормление котов
        System.out.println("===================================");
        System.out.println("   Кормление котов:");

        // Создаем миску с 50 единицами корма
        MiskaFood miska = new MiskaFood(50);

        // Создаем массив с котами
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Барсик");
        cats[2] = new Cat("Васька");
        cats[3] = new Cat("Рыжик");
        cats[4] = new Cat("Черныш");

        // Кормим котов из миски
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(miska);
        }

        // Выводим информацию о сытости котов после кормежки
        System.out.println("===================================");
        System.out.println("Состояние котов после кормления:");
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + ": " + (cats[i].sitostKota() ? "сыт" : "голоден"));
        }

        // Выводим остаток еды в миске
        System.out.println("===================================");
        System.out.println("Остаток еды в миске: " + miska.getinfoFood());

        // Добавляем еду в миску
        miska.addFood(30);
        System.out.println("После добавления еды в миске: " + miska.getinfoFood());
        System.out.println("===================================");
    }
}

