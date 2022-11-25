package extra.student_management.utils;

import extra.student_management.model.Student;
import extra.student_management.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtils {
//    private static final StudentService STUDENTSERVICE = new StudentService();
    public static void writeFile(String path, String data) {
        final File FILE = new File(path);
        try {
            final FileWriter WRITER = new FileWriter(FILE);
            final BufferedWriter BUFFERED = new BufferedWriter(WRITER);
            BUFFERED.write(data);
            BUFFERED.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeStudentFile(String path,List<Student> studentList) {
//        String PATH = "src/extra/student_management/data/StudentFile.csv";
        String header = "ID, Ten, Gioi Tinh, Ngay Sinh, Lop, Diem";
        StringBuilder data = new StringBuilder(header + "\n");
        for (Student student: studentList) {
            data.append(student.getInfor()).append("\n");
        }
        writeFile(path, data.toString());
    }
    public static void writeTeacherFile(String path, List<Teacher> teacherList) {
//        final String PATH = "src/extra/student_management/data/TeacherFile.csv";
        String header = "ID, Ten, Gioi Tinh, Ngay Sinh, Chuyen Mon";
        StringBuilder data = new StringBuilder(header + "\n");
        for (Teacher teacher: teacherList) {
            data.append(teacher.getInfor()).append("\n");
        }
        writeFile(path, data.toString());
    }
}
