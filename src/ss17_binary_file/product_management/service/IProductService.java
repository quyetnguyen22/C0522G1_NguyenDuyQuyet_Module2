package ss17_binary_file.product_management.service;

import java.io.IOException;

public interface IProductService {
    void add() throws IOException;

    void display() throws IOException;

    void lookUp() throws IOException;

}
