package extra.student_management.utils;

import java.util.Scanner;

public class FormatName {

    public static String getName(String str1) {
        Scanner scanner=new Scanner(System.in);
        String[] arr = str1.toLowerCase().trim().split("");
        StringBuilder strNew = new StringBuilder().append(arr[0].toUpperCase());
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(" ")) {
                if (arr[i - 1].equals(" ")) {
                    strNew.append(arr[i].toUpperCase());
                } else {
                    strNew.append(arr[i]);
                }
            } else if (!arr[i + 1].equals(" ")) {
                strNew.append(arr[i]);
            }
        }
        return strNew.toString();
    }
}
