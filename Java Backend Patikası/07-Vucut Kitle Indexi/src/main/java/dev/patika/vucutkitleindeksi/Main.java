package dev.patika.vucutkitleindeksi;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        double height, weight;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Boyunuzu girin: ");
        height = Double.valueOf(scanner.nextLine());

        height = (height > 2.5) ? height/100 : height;

        System.out.print("Kilonuzu girin: ");
        weight = scanner.nextInt();

        double index = weight / (height * height);

        System.out.println("Vücut kitle indeksiniz: " + index);
    }

}
