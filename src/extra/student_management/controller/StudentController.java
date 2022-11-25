package extra.student_management.controller;

import extra.student_management.service.IpersonService;
import extra.student_management.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {

    public void studentMenu() {
        IpersonService iStudent = new StudentService();
        Scanner scanner = new Scanner(System.in);
        do {
//            int choice = 0;
            try {
                System.out.println("""
                        Chọn thao tác bạn muốn thực hiện: 
                        1. Thêm thành viên.
                        2. Xóa thành viên.
                        3. Xem danh sách thành viên.
                        4. Tìm kiếm.
                        5. Sắp xếp.
                        6. Quay lại.""");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        iStudent.addMember();
                        break;
                    case 2:
                        iStudent.remove();
                        break;
                    case 3:
                        iStudent.display();
                        break;
                    case 4:
                        iStudent.lookUp();
                        break;
                    case 5:
                        iStudent.sort();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Input is incorrect!\n" +
                                "Please retry!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
        } while (true);

    }
}
