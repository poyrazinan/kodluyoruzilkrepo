package dev.patika.hipotenus.hesaplama;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);

        System.out.print("A kenarını giriniz: ");
        a = scanner.nextInt();

        System.out.print("B kenarını giriniz: ");
        b = scanner.nextInt();

        System.out.print("C kenarını giriniz: ");
        c = scanner.nextInt();

        double u = (a+b+c)/2;
        double alan = Math.sqrt(u * (u-a) * (u-b) * (u-c));
        System.out.println("Üçgenin alanı: " + alan);
    }

}
