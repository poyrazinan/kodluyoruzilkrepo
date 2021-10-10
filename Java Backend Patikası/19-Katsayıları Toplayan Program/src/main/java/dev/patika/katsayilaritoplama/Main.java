package dev.patika.katsayilaritoplama;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input, total = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Lütfen bir sayı girin: ");
            input = scanner.nextInt();

            if (input % 2 == 1)
                break;
            else if (input % 4 == 0)
                total += input;
        } while (input > 0);

        System.out.println("4'e bölünebilen sayıların toplamı: " + total);
    }
}
