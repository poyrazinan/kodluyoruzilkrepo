package dev.patika.dairealancevre;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int radius, centralAngel;
        double area;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Dairenin yarı çapını yazın: ");
        radius = scanner.nextInt();

        System.out.print("Dairenin merkez açısını giriniz: ");
        centralAngel = scanner.nextInt();

        area = (Math.PI * (radius * radius) * centralAngel) / 360;

        System.out.println("Merkez açı alanı: " + area);
    }

}
