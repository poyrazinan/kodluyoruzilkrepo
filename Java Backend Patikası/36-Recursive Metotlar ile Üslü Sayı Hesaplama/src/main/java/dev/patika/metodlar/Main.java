package dev.patika.metodlar;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int floor, ceiling;
        boolean isNegativeCeiling = false;
        Scanner scan = new Scanner(System.in);

        System.out.print("Taban değerini girin: ");
        floor = scan.nextInt();

        System.out.print("Üs değerini girin: ");
        ceiling = scan.nextInt();

        if (ceiling < 0) {
            isNegativeCeiling = true;
            ceiling *= -1;
        }

        if (floor == 0 || floor == 1 || (floor == -1 && ceiling % 2 == 0)) {
            if (floor < 0)
                System.out.println("Sonuç: " + floor * -1);
            else
                System.out.println("Sonuç: " + floor);
            return;
        }

        if (floor == -1 && ceiling % 2 != 0) {
            System.out.println("Sonuç: " + floor);
            return;
        }

        if (isNegativeCeiling)
            System.out.println("Sonuç: " + (float) 1/(power(floor, ceiling)));

        else
            System.out.println("Sonuç: " + power(floor, ceiling));

    }

    static int power(int floor, int ceiling) {
        if (ceiling == 0)
            return 1;
        int temp = ceiling-1;
        return floor * power(floor, temp);
    }
}
