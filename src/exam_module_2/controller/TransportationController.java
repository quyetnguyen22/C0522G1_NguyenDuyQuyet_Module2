package exam_module_2.controller;

import java.util.Scanner;

public class TransportationController {
    public static void transportation() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("""
                        Chon thao tac ban muon thuc hien: 
                        1. Dang ky phuong tien.
                        2. Xem danh sach dang ky phuong tien.
                        3. Huy dang ky phuong tien.
                        0. Thoat.
                        """);
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        CallTransportationController.registerTransportation();
                        break;
                    case 2:

                    case 3:

                        break;
                    case 0:
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
