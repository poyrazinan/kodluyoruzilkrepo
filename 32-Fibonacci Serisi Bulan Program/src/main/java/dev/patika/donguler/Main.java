package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int range;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen eleman sayısı girin: ");
        range = scanner.nextInt();

        long value1 = 0, value2 = 1, value3;
        System.out.print(value1 + " " + value2);
        for (int i = 2; i<=range-1; i++) {
            value3 = value2+value1;
            System.out.print(" " + value3);
            value1 = value2;
            value2 = value3;
        }
    }
}
