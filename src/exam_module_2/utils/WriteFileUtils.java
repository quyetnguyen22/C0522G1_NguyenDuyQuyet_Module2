package exam_module_2.utils;

import exam_module_2.model.Car;
import exam_module_2.model.Register;
import exam_module_2.model.Truck;
import extra.student_management.model.Student;
import extra.student_management.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtils {
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
    public static void writeCarFile(String path, List<Car> carList) {
//        String PATH = "src/extra/student_management/data/StudentFile.csv";
        String header = "ID, Ten, Gioi Tinh, Ngay Sinh, Lop, Diem";
        StringBuilder data = new StringBuilder(header + "\n");
        for (Car car: carList) {
            data.append(car.getInfo()).append("\n");
        }
        writeFile(path, data.toString());
    }
    public static void writeTruckFile(String path, List<Truck> truckList) {
        String header = "ID, Ten, Gioi Tinh, Ngay Sinh, Chuyen Mon";
        StringBuilder data = new StringBuilder(header + "\n");
        for (Truck truck: truckList) {
            data.append(truck.getInfo()).append("\n");
        }
        writeFile(path, data.toString());
    }

    public static void writeLiscenFile(String path, List<Register> registerList) {
        String header = "ID, Ten, Gioi Tinh, Ngay Sinh, Chuyen Mon";
        StringBuilder data = new StringBuilder(header + "\n");
        for (Register register: registerList) {
            data.append(register.getInfo()).append("\n");
        }
        writeFile(path, data.toString());
    }
}
