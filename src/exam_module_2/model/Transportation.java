package exam_module_2.model;

public abstract class Transportation {
    private String code;
    private String name;
    private String brand;
    private String productionDate;
    private double power;
    private double volume;

    public Transportation() {
    }

    public Transportation(String code, String name, String brand, String productionDate, double power, double volume) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.productionDate = productionDate;
        this.power = power;
        this.volume = volume;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Transportation{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", power=" + power +
                ", volume=" + volume +
                '}';
    }
}
