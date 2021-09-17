package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input, result = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayıyı girin: ");
        input = scanner.nextInt();

        for (char value : String.valueOf(input).toCharArray())
            result += Integer.parseInt(String.valueOf(value));

        System.out.println("Sayının basamaklarının toplamı: " + result);
    }
}
