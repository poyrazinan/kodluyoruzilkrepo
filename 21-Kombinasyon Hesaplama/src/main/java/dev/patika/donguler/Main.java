package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int n, r;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Eleman sayısı girin: ");
        n = scanner.nextInt();

        System.out.print("Seçim sayısı girin: ");
        r = scanner.nextInt();

        int combination = factorial(n) / (factorial(r) * factorial((n-r)));

        System.out.println("Kombinasyon: " + combination);
    }

    public static int factorial(int input) {
        int total = 1;
        for (int fact = 2; fact <= input; fact++)
            total *= fact;
        return total;
    }
}
