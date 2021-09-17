package dev.patika.manavkasa;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        double armut = 2.14, elma = 3.67, domates = 1.11, muz = 0.95, patlıcan = 5.0, totalPrice = 0.0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Armut Kaç kilo? ");
        totalPrice += scanner.nextInt()*armut;

        System.out.print("Elma Kaç kilo? ");
        totalPrice += scanner.nextInt()*elma;

        System.out.print("Domates Kaç kilo? ");
        totalPrice += scanner.nextInt()*domates;

        System.out.print("Muz Kaç kilo? ");
        totalPrice += scanner.nextInt()*muz;

        System.out.print("Patlıcan Kaç kilo? ");
        totalPrice += scanner.nextInt()*patlıcan;

        System.out.println("Toplam ödenmesi gereken ücret: " + totalPrice);
    }

}
