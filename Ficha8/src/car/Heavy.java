package car;

/**
 *
 * @author Nome : José Pedro Fernandes Número: 8190239 Turma: 1
 */
public class Heavy extends Car {

    private int loadCapacity;

    public Heavy(int loadCapacity, String name, int price, String brand, int seats) {
        super(name, price, brand, seats);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
