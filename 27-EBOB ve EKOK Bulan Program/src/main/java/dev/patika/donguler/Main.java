package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input1, input2, ebob = 1, ekok = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen 1. Sayıyı girin: ");
        input1 = scanner.nextInt();

        System.out.print("Lütfen 2. Sayıyı girin: ");
        input2 = scanner.nextInt();

        int whileLooper = 1;
        // EBOB CALCULATOR
        while (whileLooper <= input1) {
            if (input1 % whileLooper == 0 && input2 % whileLooper == 0)
                ebob = whileLooper;
            whileLooper++;
        }
        // EKOK CALCULATOR
        ekok = (input1 * input2) / ebob;

        System.out.println("EBOB: " + ebob
                + "\nEKOK: " + ekok);
    }
}
