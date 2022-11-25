package extra.student_management.controller;

import extra.student_management.service.IpersonService;
import extra.student_management.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {

    public void teacherMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        IpersonService iTeacher = new TeacherService();
        do {
            int choice = 0;
            try {
                System.out.println("""
                    Chọn thao tác bạn muốn thực hiện: 
                    1. Thêm thành viên.
                    2. Xóa thành viên.
                    3. Xem danh sách thành viên.
                    4. Tìm kiếm.
                    5. Sắp xếp.
                    6. Quay lại.""");
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Input is incorrect!\n" +
                        "Please retry!");
            }
            switch (choice) {
                case 1:
                    iTeacher.addMember();
                    break;
                case 2:
                    iTeacher.remove();
                    break;
                case 3:
                    iTeacher.display();
                    break;
                case 4:
                    iTeacher.lookUp();
                    break;
                case 5:
                    iTeacher.sort();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Input is incorrect!\n" +
                            "Please retry!");
                    break;
            }
        } while (true);

    }
}
