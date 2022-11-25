package ss17_binary_file.product_management.view;

import ss17_binary_file.product_management.controller.ProductController;

import java.io.IOException;

public class View {
    public static void main(String[] args) {
        try {
            ProductController.productMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
