package ss17_binary_file.copy_file_binary.controller;

import ss17_binary_file.product_management.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileBinary {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> readSourceFile() {
        List<String> strings;
        while (true) {
            try {
                System.out.println("Source file binary:");
                String sourcePath = SCANNER.nextLine();
                FileInputStream fileInputStream = new FileInputStream(sourcePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                strings = (List<String>) objectInputStream.readObject();
                objectInputStream.close();
                break;
            } catch (FileNotFoundException | ClassNotFoundException e) {
                System.err.println("NOT found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    public static void writeSourceFile() {
        List<String> newStrings = readSourceFile();
        System.out.println("Target file binary:");
        String targetPath = SCANNER.nextLine();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(newStrings);
            System.out.println("Copy Successfully!");
            objectOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeSourceFile();
    }
}
