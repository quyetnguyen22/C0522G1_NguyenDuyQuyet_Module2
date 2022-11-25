package exam_module_2.controller;

import exam_module_2.service.ICar;
import exam_module_2.service.impl.RegisterCarService;

import java.util.Scanner;

public class CallTransportationController {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ICar I_CAR = new RegisterCarService();
    public static void registerTransportation() {

        do {
            try {
                System.out.println("""
                        Chon phuong tien ban muon dang ky: 
                        1. Oto.
                        2. Xe tai.
                        0. Thoat.
                        """);
                int choice = Integer.parseInt(SCANNER.nextLine());

                switch (choice) {
                    case 1:
                        I_CAR.add();
                        break;
                    case 2:

                        break;
                    case 3:
                        return;
                    default:
                        throw new IllegalStateException();
                }
            } catch (NumberFormatException | IllegalStateException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
        } while (true);

    }

    public static void displayTransportation() {
        do {
            try {
                System.out.println("""
                        Chon phuong tien ban muon hien thi: 
                        1. Oto.
                        2. Xe tai.
                        0. Thoat.
                        """);
                int choice = Integer.parseInt(SCANNER.nextLine());

                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        return;
                    default:
                        throw new IllegalStateException();
                }
            } catch (NumberFormatException | IllegalStateException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
        } while (true);

    }

    public static void removeTransportation() {
        do {
            try {
                System.out.println("""
                        Chon phuong tien ban muon xoa: 
                        1. Oto.
                        2. Xe tai.
                        0. Thoat.
                        """);
                int choice = Integer.parseInt(SCANNER.nextLine());

                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        return;
                    default:
                        throw new IllegalStateException();
                }
            } catch (NumberFormatException | IllegalStateException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
        } while (true);

    }
}
