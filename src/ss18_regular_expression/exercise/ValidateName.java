package ss18_regular_expression.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName {
    private static Pattern pattern;
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void complileName() {
        String name = "[APC][0-9]{4}[G-M]";
        pattern = Pattern.compile(name);
    }
    public static boolean validateName(String string) {
        Matcher matcher = pattern.matcher(string);
         return matcher.matches();
    }
    public static void main(String[] args) {
        System.out.println("Input class name:");
        String className = SCANNER.nextLine();
        complileName();
        boolean isTrue = validateName(className);
        if (isTrue) {
            System.out.println("True");
            return;
        }
        System.out.println("False");
    }
}
