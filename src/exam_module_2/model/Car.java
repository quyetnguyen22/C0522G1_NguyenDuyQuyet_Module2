package exam_module_2.model;

public class Car extends Transportation{

    private int capacity;
    private String engine;

    public Car(int capacity, String engine) {
        this.capacity = capacity;
        this.engine = engine;
    }

    public Car(String code, String name, String brand, String productionDate, double power,
               double volume, int capacity, String engine) {
        super(code, name, brand, productionDate, power, volume);
        this.capacity = capacity;
        this.engine = engine;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getCode(), this.getName(), this.getBrand(),
                this.getProductionDate(), this.getPower(), this.getVolume(), this.getCapacity(), this.getEngine());
    }

    @Override
    public String toString() {
        return super.toString() +
                "Car{" +
                "capacity=" + capacity +
                ", engine='" + engine + '\'' +
                '}';
    }
}
