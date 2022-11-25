package extra.student_management.service.impl;

import extra.student_management.exception.DuplicateIDException;
import extra.student_management.model.Student;
import extra.student_management.model.Teacher;
import extra.student_management.service.IpersonService;
import extra.student_management.sort.ComparatorTeacher;
import extra.student_management.utils.ReadFileUtils;
import extra.student_management.utils.WriteFileUtils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class TeacherService implements IpersonService {
    private static final String PATH = "src/extra/student_management/data/TeacherFile.csv";
    private static final String DATE = "[0-3][0-9]/[0-1][0-9]/[0-2][0-9]{3}";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Teacher inforTeacher() {
        String id;
        String dateOfBirth;
        String gender;
        String name;
        String specialist;
        do {
            try {
                List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
                if (teacherList.isEmpty()) {
                    id = "TC-01";
                } else {
                    String[] idUp = teacherList.get(teacherList.size() - 1).getId().split("-");
                    id = "TC-" + (Integer.parseInt(idUp[1]) + 1);
                    System.out.println("ID= " + id);
                    boolean isExist = false;
                    for (Teacher teacher : teacherList) {
                        if (teacher.getId().equals(id)) {
                            isExist = true;
                            try {
                                throw new DuplicateIDException("\nID này đã tồn tại!");
                            } catch (DuplicateIDException e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                    if (!isExist) {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("""
                        Bạn đã nhập sai!
                        Hãy nhập lại 1 số lớn hơn 0!""");
            }
        } while (true);
        System.out.println("Nhập tên: ");
        name = SCANNER.nextLine();
        do {
            try {
                System.out.println("Nhập ngày sinh: ");
                dateOfBirth = SCANNER.nextLine();
                if (dateOfBirth.matches(DATE)) {
                    break;
                } else {
                    try {
                        throw new DataFormatException("""
                                Bạn đã nhập sai!
                                Hãy nhập lại ngày vói định dạng dd/MM/yyy!""");
                    } catch (DataFormatException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("""
                                                
                        Bạn đã nhập sai!
                        Hãy nhập lại ngày vói định dạng dd/MM/yyy!""");
            }
        } while (true);
        System.out.println("Nhập giới tính: ");
        gender = SCANNER.nextLine();
        System.out.println("Nhập chuyên môn: ");
        specialist = SCANNER.nextLine();
        return new Teacher(id, name, gender, dateOfBirth, specialist);

    }

    @Override
    public void addMember() {
        List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
        Teacher teacher = inforTeacher();
        teacherList.add(teacher);
        WriteFileUtils.writeTeacherFile(PATH, teacherList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
        System.out.println("Nhập thành viên(ID) bạn muốn xóa:");
        String idRemove = SCANNER.nextLine();
        boolean isEmpty = false;
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(idRemove)) {
                System.out.print("Bạn có chắc muốn xóa ID: " + idRemove + " này không?\n" +
                        "1. Có\n" +
                        "2. Không\n");
                int confirm = Integer.parseInt(SCANNER.nextLine());
                if (confirm == 1) {
                    teacherList.remove(teacher);
                    WriteFileUtils.writeTeacherFile(PATH, teacherList);
                    System.out.printf("Xóa thành công ID: %s\n", idRemove);
                }
                isEmpty = true;
                break;
            }
        }
        if (!isEmpty) {
            System.err.println("Không tìm thấy ID");
        }
    }


    @Override
    public void display() {
        List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
        if (teacherList.isEmpty()) {
            System.err.println("Danh sách trống!");
            return;
        }
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

    }

    @Override
    public void lookUp() {
        List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
        do {
            System.out.println("""
                    Tìm kiếm.
                    1. Theo ID.
                    2. Theo tên.
                    3. Quay lại.""");
            int choice = Integer.parseInt(SCANNER.nextLine());
            if (choice == 1) {
                System.out.println("Nhập ID bạn muốn tìm kiếm:");
                String idLookUp = SCANNER.nextLine();
                boolean isFlag = false;
                for (Teacher teacher : teacherList) {
                    if (teacher.getId().equals(idLookUp)) {
                        System.out.println(teacher);
                        isFlag = true;
                        break;
                    }
                }
                if (!isFlag) {
                    System.err.println("Không tìm thấy ID");
                }
            }
            if (choice == 2) {
                System.out.println("Nhập tên bạn muốn tìm kiếm:");
                CharSequence nameLookUp = SCANNER.nextLine();
                boolean isFlag = false;
                for (Teacher teacher : teacherList) {
                    if (teacher.getName().contains(nameLookUp)) {
                        System.out.println(teacher);
                        isFlag = true;
                    }
                }
                if (!isFlag) {
                    System.err.println("Không tìm thấy tên!");
                }
            } else if (choice == 3) {
                return;
            } else {
                System.err.println("Nhập sai!\n" +
                        "Vui lòng nhập lại!");
            }
        } while (true);
    }

    @Override
    public void sort() {
        List<Teacher> teacherList = ReadFileUtils.readTeacherFile(PATH);
        if (teacherList.isEmpty()) {
            System.err.println("Danh sách trống!");
        } else {
            do {
                System.out.println("""
                        Sắp xếp.
                        1. Theo tên.
                        2. Theo ID.
                        3. Quay lại.""");
                int choice = Integer.parseInt(SCANNER.nextLine());

                if (choice == 1) {
                    Collections.sort(teacherList);
                    System.out.println(teacherList);
                } else if (choice == 2) {
                    teacherList.sort(Collections.reverseOrder(new ComparatorTeacher()));
                    System.out.println(teacherList);
                } else if (choice == 3) {
                    return;
                } else {
                    System.err.println("Nhập sai!\n" +
                            "Vui lòng nhập lại!");
                }
            } while (true);
        }
    }
}

