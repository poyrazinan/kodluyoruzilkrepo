package dev.patika.kdv.hesaplama;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        double tutar, kdv = 0.18;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satış tutarını girin: ");
        tutar = scanner.nextInt();

        kdv = (tutar > 1000) ? 0.08 : 0.18;

        System.out.println("KDV Oranı: %" + (kdv*100) +
                "\nKDV Ücreti: " + tutar*kdv + "TL " +
                "\nTahsil edilen para: " + (tutar-tutar*kdv) + "TL");

    }

}
