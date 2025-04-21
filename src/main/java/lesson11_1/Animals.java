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


