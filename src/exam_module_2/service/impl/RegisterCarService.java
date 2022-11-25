package exam_module_2.service.impl;

import exam_module_2.model.Register;
import exam_module_2.service.ICar;
import exam_module_2.utils.ReadFileUtils;
import exam_module_2.utils.WriteFileUtils;

import java.util.List;
import java.util.Scanner;

public class RegisterCarService implements ICar {

    private static final String PATH_CAR = "src/exam_module_2/data/phuongTien.csv";
    private static final String PATH_LISCEN = "src/exam_module_2/data/gdkpt.csv";


    public Register infoRegisterCar() {

        Scanner scanner = new Scanner(System.in);

        String registerNumber;
        String nameOfOwn;
        String code;
        String registerDate;

        System.out.print("So dang ky:");
        registerNumber = scanner.nextLine();

        System.out.print("Ten chu so huu:\n");
        nameOfOwn = scanner.nextLine();

        System.out.print("Ma phuong tien:\n");
        code = scanner.nextLine();
        System.out.print("Ngay dang ky:");
        registerDate = scanner.nextLine();

        return new Register(registerNumber, nameOfOwn, code, registerDate);
    }

    @Override
    public void add() {
        List<Register> registers = ReadFileUtils.readLiscen(PATH_LISCEN);
        Register register = infoRegisterCar();
        registers.add(register);
        WriteFileUtils.writeLiscenFile(PATH_LISCEN, registers);
        System.out.println("Them moi thanh cong!");
    }
}
