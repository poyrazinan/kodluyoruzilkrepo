package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input;
        double result = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayıyı girin: ");
        input = scanner.nextInt();

        for (double value = 1; value <= input; value++)
            result += (1/value);

        System.out.println("Sayının Harmonik Serisi: " + result);
    }
}
