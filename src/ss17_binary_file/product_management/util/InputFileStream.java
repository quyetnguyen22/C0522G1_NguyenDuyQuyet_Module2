package ss17_binary_file.product_management.util;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.EOFException;
import ss17_binary_file.product_management.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputFileStream {
    public static List<Product> inputFile(String path) throws IOException {
        List<Product> products = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
        System.out.println(e.getMessage());
    }
        return products;
    }
}
