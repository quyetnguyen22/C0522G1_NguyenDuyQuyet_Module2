package extra.student_management.controller;

import java.io.IOException;
import java.util.Scanner;

public class ManagementController {
    public static void managementControl() throws IOException {
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        Scanner scanner = new Scanner(System.in);
        do {
            int choice = 0;
            try {
                System.out.println("""
                        Chọn đối tượng bạn muốn thao tác:
                        1. Giảng viên.
                        2. Học sinh.
                        3. Thoát.
                        """);
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }

            switch (choice) {
                case 1 -> teacherController.teacherMenu();
                case 2 -> studentController.studentMenu();
                case 3 -> System.exit(1);
                default -> System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
        } while (true);

    }
}
