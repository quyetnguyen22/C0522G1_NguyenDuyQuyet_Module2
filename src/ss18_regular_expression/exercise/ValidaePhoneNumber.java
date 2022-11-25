package ss18_regular_expression.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaePhoneNumber {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Pattern pattern;
    public static void complileNum() {
        String number =  ("[(][0-9]{2}[)]-0[0-9]{9}");
        pattern = Pattern.compile(number);
    }
    public static void validateNum(String number) {
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            System.out.println("True");
            return;
        }
        System.out.println("False");
    }

    public static void main(String[] args) {
        System.out.println("Input your number:");
        String number = SCANNER.nextLine();
        complileNum();
        validateNum(number);
    }
}
