package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount of money that you want to exchange: ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.printf("%.2f USD: %.0f Vnd", usd, vnd);
    }
}
