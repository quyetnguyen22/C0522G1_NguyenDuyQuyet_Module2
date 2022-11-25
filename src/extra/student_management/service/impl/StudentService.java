package extra.student_management.service.impl;

import extra.student_management.exception.DuplicateIDException;
import extra.student_management.model.Student;
import extra.student_management.service.IpersonService;
import extra.student_management.sort.ComparatorStudent;
import extra.student_management.utils.FormatName;
import extra.student_management.utils.ReadFileUtils;
import extra.student_management.utils.WriteFileUtils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class StudentService implements IpersonService {
    private static final String PATH = "src/extra/student_management/data/StudentFile.csv";
    private static final String DATE = "((0[1-9])|([12][0-9])|(3[01]))/((0[1-9])|(1[0-2]))/([0-9]{4})";
    private static final Scanner scanner = new Scanner(System.in);

    public static Student infoStudent() {
        String id;
        double score;
        String name;
        String gender;
        String dateOfBirth;
        String grade;
        do {
            try {
                List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
                if (studentList.isEmpty()) {
                    id = "SV-01";
                } else {
                    String[] idUp = studentList.get(studentList.size() - 1).getId().split("-");
                    id = "SV-" + (Integer.parseInt(idUp[1]) + 1);
                    System.out.println("ID= " + id);
                    boolean isExist = false;
                    for (Student student : studentList) {
                        if (student.getId().equals(id)) {
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
        name = FormatName.getName(scanner.nextLine());
        do {
            try {
                System.out.println("Nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
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
                        Hãy nhập lại ngày vói định dạng yyyy-mm-dd!""");
            }
        } while (true);

        System.out.println("Nhập giới tính: ");
        gender = scanner.nextLine();
        System.out.println("Nhập lớp: ");
        grade = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập điểm: ");
                score = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("""
                                                
                        Bạn đã nhập sai!
                        Hãy nhập lại 1 số lớn hơn 0!""");
            }
        } while (true);
        return new Student(id, name, gender, dateOfBirth, grade, score);
    }

    @Override
    public void addMember() {
        List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
//        studentList.get(studentList.size()-1).getId();
        Student student = infoStudent();
        studentList.add(student);
        WriteFileUtils.writeStudentFile(PATH, studentList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
        System.out.println("Nhập thành viên(ID) bạn muốn xóa:");
        String idRemove = scanner.nextLine();

        boolean isEmpty = false;
        for (Student student : studentList) {
            if (student.getId().equals(idRemove)) {
                System.out.print("Bạn có chắc muốn xóa ID: " + idRemove + " này không?\n" +
                        "1. Có\n" +
                        "2. Không\n");
                int confirm = Integer.parseInt(scanner.nextLine());
                if (confirm == 1) {
                    studentList.remove(student);
                    WriteFileUtils.writeStudentFile(PATH, studentList);
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
        List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
        if (studentList.isEmpty()) {
            System.err.println("Danh sách trống!");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void lookUp() {
        List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
        do {
            System.out.println("""
                    Tìm kiếm.
                    1. Theo ID.
                    2. Theo tên.
                    3. Quay lại.""");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Nhập ID bạn muốn tìm kiếm:");
                String idLookUp = scanner.nextLine();
                boolean isFlag = false;
                for (Student student : studentList) {
                    if (student.getId().equals(idLookUp)) {
                        System.out.println(student);
                        isFlag = true;
                        break;
                    }
                }
                if (!isFlag) {
                    System.err.println("Không tìm thấy ID");
                }
            } else if (choice == 2) {
                System.out.println("Nhập tên bạn muốn tìm kiếm:");
                String nameLookUp = scanner.nextLine();
                boolean isFlag = false;
                for (Student student : studentList) {
                    if (student.getName().contains(nameLookUp)) {
                        System.out.println(student);
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
        List<Student> studentList = ReadFileUtils.readStudentFile(PATH);
        if (studentList.isEmpty()) {
            System.err.println("Danh sách trống!");
        } else {
            do {
                System.out.println("""
                        Sắp xếp.
                        1. Theo tên.
                        2. Theo ID.
                        3. Quay lại.""");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    Collections.sort(studentList);
                    System.out.println(studentList);
                } else if (choice == 2) {
                    studentList.sort(Collections.reverseOrder(new ComparatorStudent()));
                    System.out.println(studentList);
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
