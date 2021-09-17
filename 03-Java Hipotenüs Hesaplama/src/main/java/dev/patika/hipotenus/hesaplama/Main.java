package dev.patika.hipotenus.hesaplama;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int a, b;
        double c;
        Scanner scanner = new Scanner(System.in);

        System.out.print("A kenarını giriniz: ");
        a = scanner.nextInt();

        System.out.print("B kenarını giriniz: ");
        b = scanner.nextInt();

        c = Math.sqrt((a*a)+(b*b));
        System.out.println("Hipotenüs: " + c);
    }

}
