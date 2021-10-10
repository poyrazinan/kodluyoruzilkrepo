package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int floor,ceiling, result = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen alt sayıyı yazın: ");
        floor = scanner.nextInt();

        System.out.print("Lütfen üst sayıyı yazın: ");
        ceiling = scanner.nextInt();

        for (int i = 1 ; i <= ceiling; i++)
            result *= floor;

        System.out.println("Üslü sayı cevabı: " + result);


    }
}
