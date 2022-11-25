package exam_module_2.model;

public class Truck extends Transportation{
    private double load;

    public Truck(double load) {
        this.load = load;
    }

    public Truck(String code, String name, String brand, String productionDate, double power,
                 double volume, double load) {
        super(code, name, brand, productionDate, power, volume);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.getCode(), this.getName(), this.getBrand(),
                this.getProductionDate(), this.getPower(), this.getVolume(), this.getLoad());
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Truck{" +
                "load=" + load +
                '}';
    }
}
