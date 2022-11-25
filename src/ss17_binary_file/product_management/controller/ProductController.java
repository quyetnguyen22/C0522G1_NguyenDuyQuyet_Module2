package ss17_binary_file.product_management.controller;

import ss17_binary_file.product_management.service.IProductService;
import ss17_binary_file.product_management.service.impl.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private static final IProductService I_PRODUCT_SERVICE = new ProductService();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void productMenu() throws IOException {
        do {
            int choice = 0;
            try {
                System.out.print("""
                    ****Product management****
                    1. Add new product.
                    2. Display list product.
                    3. Look Up a product.
                    4. Exit.
                    """);
                choice = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("""
                        You entered wrong format!!
                        """);
            }

            switch (choice) {
                case 1:
                    I_PRODUCT_SERVICE.add();
                    break;
                case 2:
                    I_PRODUCT_SERVICE.display();
                    break;
                case 3:
                    I_PRODUCT_SERVICE.lookUp();
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("""
                            Input a number on menu!
                            Please retry!
                            """);
                    break;
            }
        } while (true);

    }

}
