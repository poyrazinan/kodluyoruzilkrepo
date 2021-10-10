package dev.patika.ucakbileti;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int km, age, type;
        double perKm = 0.1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Yolculuk kaç KM olacak: ");
        km = scanner.nextInt();
        if (km <= 0) {
            System.out.println("Yolculuk mesafesi pozitif bir değer olmalıdır.");
            return;
        }

        System.out.print("Yaşınızı girin: ");
        age = scanner.nextInt();
        if (age < 0) {
            System.out.println("Yaşınız pozitif olmalıdır.");
            return;
        }

        System.out.print("Yolculuk tipi seçin (1 => Tek Yön, 2 => Gidiş geliş): ");
        type = scanner.nextInt();
        if (!(type == 1 || type == 2)) {
            System.out.println("Yolculuk tipi 1 veya 2 olmalıdır.");
            return;
        }

        double ticketPrice = km*perKm;
        double discount = 0;
        if (age < 12)
            discount = ticketPrice/2;
        else if (age <= 24)
            discount = ticketPrice/10;
        else if (age >= 65)
            discount = ticketPrice*3/10;

        if (type == 2)
            discount += (ticketPrice/5);

        ticketPrice -= discount;

        System.out.println("Bilet Fiyatı: " + ticketPrice);
    }
}
