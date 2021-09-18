package dev.patika.metodlar;

import java.util.Scanner;

public class Main {

    static int num = 1;

    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Sayı girin: ");
        num = scan.nextInt();
        if (primeChecker(num/2))
            System.out.println(num + " Sayısı asaldır");
        else
            System.out.println(num + " Sayısı asal değildir.");
    }

    static boolean primeChecker(int temp) {
        if (temp == 1)
            return true;

        if (num % temp == 0)
            return false;

        else {
            temp -= 1;
            return primeChecker(temp);
        }
    }
}
