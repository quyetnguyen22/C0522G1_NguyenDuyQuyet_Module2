package extra.student_management.utils;

import extra.student_management.model.Student;
import extra.student_management.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtils {
    public static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                    list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File is not found!");
        }
//        System.out.println(list);
        return list;
    }

    public static List<Student> readStudentFile(String path) {
        List<String> newList = null;
        try {
            newList = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Student> students = new ArrayList<>();

        String[] info;
        for (String studentList : newList) {
            info = studentList.split(",");
            students.add(new Student(info[0], info[1], info[2], info[3], info[4],
                    Double.parseDouble(info[5])));
        }
        return students;
    }

    public static List<Teacher> readTeacherFile(String path) {
        List<String> newList = null;
        try {
            newList = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Teacher> teachers = new ArrayList<>();

        String[] info;
        for (String teacherList : newList) {
            info = teacherList.toLowerCase().split(",");
            teachers.add(new Teacher(info[0], info[1], info[2], info[3], info[4]));
        }
        return teachers;
    }
}
