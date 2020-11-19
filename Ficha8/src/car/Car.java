package car;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Car implements Comparable<Car> {

    private String name;

    private int price;

    private String brand;

    private int seats;

    public Car(String name, int price, String brand, int seats) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public int compareTo(Car o) {
        return this.price - o.getPrice();
    }
}
