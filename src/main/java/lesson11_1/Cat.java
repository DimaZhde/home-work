package lesson11_1;

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
