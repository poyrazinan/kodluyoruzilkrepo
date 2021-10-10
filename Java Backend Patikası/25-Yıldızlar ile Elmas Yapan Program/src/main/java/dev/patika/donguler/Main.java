package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayıyı girin: ");
        input = scanner.nextInt()/2;

        for (int looper = 1; looper <= input; looper++) {
            for (int emptyLooper = 1; emptyLooper <= (input - looper); emptyLooper++)
                System.out.print(" ");

            for (int starLooper = 1; starLooper <= (2 * looper) - 1; starLooper++)
                System.out.print("*");

            System.out.println();
        }

        for (int backwards = input-1; backwards >= 1; backwards--) {
            for (int emptyLooper = 1; emptyLooper <= (input - backwards); emptyLooper++)
                System.out.print(" ");

            for (int starLooper = 1; starLooper <= (2 * backwards) - 1; starLooper++)
                System.out.print("*");

            System.out.println();
        }
    }
}
