package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int input, sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        input = scanner.nextInt();

        for (int divider = 1 ; divider < input; divider++)
            if (input % divider == 0)
                sum += divider;

        if (sum == input)
            System.out.println(input + " Mükemmel sayıdır.");
        else
            System.out.println(input + " Mükemmel sayı değildir.");
    }
}
