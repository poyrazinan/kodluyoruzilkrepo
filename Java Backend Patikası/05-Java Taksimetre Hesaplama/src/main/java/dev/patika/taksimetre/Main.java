package dev.patika.taksimetre;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int kmInput;
        double perKm = 2.2, total = 10;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç KM Gittiğinizi yazın: ");
        kmInput = scanner.nextInt();

        total += (perKm * kmInput);
        total = (total < 20) ? 20 : total;
        System.out.println("Toplam Ücret: " + total);
    }

}
