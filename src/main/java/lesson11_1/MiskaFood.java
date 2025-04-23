package lesson11_1;

class MiskaFood {
    private int food;

    public MiskaFood(int nachaloFood) {
        this.food = nachaloFood;
    }

    public boolean umenshenieFood(int korm) {
        if (korm <= 0) {
            return false;
        }
        if (this.food >= korm) {
            this.food -= korm;
            return true;
        }
        return false;
    }

    public void addFood(int korm) {
        this.food += korm;
    }

    public int getinfoFood() {
        return this.food;
    }
}
