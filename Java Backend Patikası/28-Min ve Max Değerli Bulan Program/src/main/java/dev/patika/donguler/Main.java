package dev.patika.donguler;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        int minValue = 0, maxValue = 0, inputAmount, inputRegistered = 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Lütfen kaç adet sayı gireceğinizi yazın: ");
            inputAmount = scanner.nextInt();
        } while (inputAmount < 2);

        while (inputRegistered <= inputAmount) {
            System.out.print("Lütfen " + inputRegistered + ". Sayıyı girin: ");
            int currentInput = scanner.nextInt();

            if (inputRegistered == 1) {
                minValue = currentInput;
                maxValue = currentInput;
            }

            if (currentInput > maxValue)
                maxValue = currentInput;

            if (currentInput < minValue)
                minValue = currentInput;

            inputRegistered++;
        }

        System.out.println("En küçük değer: " + minValue
            + "\nEn büyük değer: " + maxValue);
    }
}
