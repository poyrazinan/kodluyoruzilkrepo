package dev.patika.artikyil;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        boolean isLeapYear;
        int leapYear;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Yılı giriniz: ");
        leapYear = scanner.nextInt();
        isLeapYear = (leapYear%4 == 0);

        if (isLeapYear)
            System.out.println(leapYear + " bir artık yıldır !");
        else
            System.out.println(leapYear + " bir artık yıl değildir!");
    }
}
