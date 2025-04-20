package lesson11_1;

class Animals {
    private String name;
    private static int totalAnimals = 0;

    public Animals(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public String getName() {
        return name;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }
}

class Dog extends Animals {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int totalDogs = 0;

    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(getName() + " не может проплыть " + distance + " м.");
        }
    }

    public static int getTotalDogs() {
        return totalDogs;
    }
}

class Cat extends Animals {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int totalCats = 0;
    private boolean sitost;
    private int appetite = 15; // Сколько еды нужно коту для насыщения

    public Cat(String name) {
        super(name);
        totalCats++;
        this.sitost = false; // При создании кот полностью голодный
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать");
    }

    public static int getTotalCats() {
        return totalCats;
    }

    public void eat(MiskaFood bowl) {
        if (bowl.umenshenieFood(appetite)) {
            this.sitost = true;
            System.out.println(getName() + " поел и теперь сыт!");
        } else {
            System.out.println(getName() + " не смог поесть, в миске недостаточно еды!");
        }
    }

    public boolean sitostKota() {
        return sitost;
    }
}
