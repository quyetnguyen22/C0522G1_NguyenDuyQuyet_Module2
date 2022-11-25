package ss17_binary_file.product_management.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String brand;
    private String others;
    private double price;

    public Product() {
    }

    public Product(String productCode, String productName, String brand, String others, double price) {
        this.productCode = productCode;
        this.productName = productName;
        this.brand = brand;
        this.others = others;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getInfor() {
        return String.format("%s, %s, %s %f, %s", this.getProductCode(), this.productName, this.brand, this.price, this.others);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", others='" + others + '\'' +
                ", price=" + price +
                '}';
    }
}
