package ss17_binary_file.product_management.service.impl;

import ss17_binary_file.product_management.model.Product;
import ss17_binary_file.product_management.service.IProductService;
import ss17_binary_file.product_management.util.InputFileStream;
import ss17_binary_file.product_management.util.OutputFileStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    List<Product> productList = new ArrayList<>();
    private static final String PATH = "src/ss17_binary_file/product_management/data/data.txt";
    private static final Scanner SCANNER = new Scanner(System.in);
    public static Product productInfor() {
        String productCode;
        String productName;
        String brand;
        String others;
        double price;
        System.out.print("Product code:");
        productCode = SCANNER.nextLine();
        System.out.print("Product name");
        productName = SCANNER.nextLine();
        System.out.print("Brand:");
        brand = SCANNER.nextLine();
        do {
            try {
                System.out.print("Price:");
                price = Double.parseDouble(SCANNER.nextLine());
                break;
            }catch (NumberFormatException e) {
                System.out.println("wrong input!\n" +
                        "Please retry!");
            }
        }while (true);
        System.out.print("Other:");
        others = SCANNER.nextLine();
        Product product = new Product(productCode, productName, brand,others, price);
        return product;
    }
    @Override
    public void add() throws IOException {
        Product product = productInfor();
        productList.add(product);
        OutputFileStream.outputFile(PATH, productList);
        productList = InputFileStream.inputFile(PATH);
    }

    @Override
    public void display() throws IOException {
        productList = InputFileStream.inputFile(PATH);
        if (productList.isEmpty()) {
            System.out.println("The infomation is NOT exist!");
            return;
        }
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void lookUp() throws IOException {
        List<Product> productList = InputFileStream.inputFile(PATH);
        System.out.println("Enter product code that you want to look up:");
        String codeLookUp = SCANNER.nextLine();
        if (productList.isEmpty()) {
            System.out.println("The infomation is NOT exist!");
            return;
        }
        boolean isExist = true;
        for (Product product : productList) {
            if (codeLookUp.equals(product.getProductCode())) {
                System.out.println(product);
                isExist = false;
                break;
            }
        }
        if (isExist) {
            System.out.println("The infomation is NOT exist!");
        }
    }
}
