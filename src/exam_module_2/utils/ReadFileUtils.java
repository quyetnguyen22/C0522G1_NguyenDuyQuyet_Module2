package exam_module_2.utils;


import exam_module_2.model.Car;
import exam_module_2.model.Register;
import exam_module_2.model.Truck;

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
        return list;
    }

    public static List<Car> readCar(String path) {
        List<String> newList = null;
        try {
            newList = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Car> carList = new ArrayList<>();

        String[] info;
        for (String lists : newList) {
            info = lists.split(",");
            carList.add(new Car(info[0], info[1], info[2], info[3], Double.parseDouble(info[4]),
                    Double.parseDouble(info[5]), Integer.parseInt(info[6]), info[7]));
        }
        return carList;
    }

    public static List<Truck> readTruck(String path) {
        List<String> newList = null;
        try {
            newList = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Truck> truckList = new ArrayList<>();

        String[] info;
        for (String lists : newList) {
            info = lists.split(",");
            truckList.add(new Truck(info[0], info[1], info[2], info[3], Double.parseDouble(info[4]),
                    Double.parseDouble(info[5]), Double.parseDouble(info[6])));

        }
        return truckList;
    }

    public static List<Register> readLiscen(String path) {
        List<String> newList = null;
        try {
            newList = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Register> registerList = new ArrayList<>();

        String[] info;
        for (String lists : newList) {
            info = lists.split(",");
            registerList.add(new Register(info[0], info[1], info[2], info[3]));

        }
        return registerList;
    }
}
