package ss17_binary_file.product_management.util;

import ss17_binary_file.product_management.model.Product;

import java.io.*;
import java.util.List;

public class OutputFileStream {

    public static void outputFile(String path, List<Product> productList) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(productList);
            objectOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
