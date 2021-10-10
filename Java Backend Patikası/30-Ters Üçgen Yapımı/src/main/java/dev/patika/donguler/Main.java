package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayıyı girin: ");
        input = scanner.nextInt();

        for (int backwards = input-1; backwards >= 1; backwards--) {
            for (int emptyLooper = 1; emptyLooper <= (input - backwards); emptyLooper++)
                System.out.print(" ");

            for (int starLooper = 1; starLooper <= (2 * backwards) - 1; starLooper++)
                System.out.print("*");

            System.out.println();
        }
    }
}
