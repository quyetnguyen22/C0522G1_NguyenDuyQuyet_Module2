package exam_module_2.service.impl;

import exam_module_2.model.Register;
import exam_module_2.service.ITruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterTruckService implements ITruck {
    List<Register> registers = new ArrayList<>();

    public Register infoRegisterTruck() {

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
        Register register = infoRegisterTruck();
        registers.add(register);
        System.out.println(registers);
        System.out.println("Them moi thanh cong!");
    }
}
