//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об:
//      аттракционах, времени их работы и стоимости
package lesson06.park;
public class Park {
    private String parkName;    // название парка

    // Конструктор класса Парк
    public Park(String parkName) {
        this.parkName = parkName;
    }

    // Создаем класс для Аттракционов
    public class Attraction {
        private String attractionName;  // название аттракциона
        private String timeWorking;       // время работы аттракциона
        private int Price;              // стоимость билета

        // Конструктор класса Аттракцион
        public Attraction(String attractionName, String timeWorking, int Price) {
            this.attractionName = attractionName;
            this.timeWorking = timeWorking;
            this.Price = Price;
        }

        // Метод для вывода информации о аттракционе в консоль
        public void vivodInfoAttraction() {
            System.out.println("\n----------------------");
            System.out.println("Парк: " + parkName);
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + timeWorking);
            System.out.println("Стоимость билета: " + Price + " рублей");
        }
    }

    // Создаем парк - Парк развлечений
    public static void main(String[] args) {
        Park parkRazvlecheniy = new Park("Парк развлечений\n----------------------");

        // Создаем аттракционы
        Park.Attraction americanMountain = parkRazvlecheniy.new Attraction(
                "Американские горки",
                "10:00 - 20:00",
                250);

        Park.Attraction horses = parkRazvlecheniy.new Attraction(
                "Лошадки",
                "09:00 - 19:30",
                150);

        Park.Attraction batut = parkRazvlecheniy.new Attraction(
                "Батут",
                "09:00 - 19:30",
                150);

        // Вывод информации об аттракционах в консоль
        americanMountain.vivodInfoAttraction();
        horses.vivodInfoAttraction();
        batut.vivodInfoAttraction();
    }
}
